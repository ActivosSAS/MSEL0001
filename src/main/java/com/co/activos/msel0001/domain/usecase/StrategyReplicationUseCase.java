package com.co.activos.msel0001.domain.usecase;

import com.co.activos.msel0001.domain.exceptions.ReplicationException;
import com.co.activos.msel0001.domain.model.activos.detailReplication.DetailReplication;
import com.co.activos.msel0001.domain.model.activos.detailReplication.gateway.DetailReplicationGateway;
import com.co.activos.msel0001.domain.model.activos.detailReplication.util.State;
import com.co.activos.msel0001.domain.model.reclutador.basicInformation.BasicInformation;
import com.co.activos.msel0001.domain.model.reclutador.basicInformation.gateway.BasicInformationGateway;
import com.co.activos.msel0001.domain.model.strategy.ReplicateType;
import com.co.activos.msel0001.domain.model.strategy.StrategyReplication;
import com.co.activos.msel0001.helpers.constants.Errors;
import com.co.activos.msel0001.helpers.event.XMLParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.co.activos.msel0001.helpers.constants.Errors.NO_STRATEGY_FOUND;


@Service
public class StrategyReplicationUseCase {

    private static final Logger logger = LoggerFactory.getLogger(StrategyReplicationUseCase.class);

    private final BasicInformationGateway basicInformationGateway;
    private final DetailReplicationGateway detailReplicationGateway;
    private final Map<ReplicateType, StrategyReplication> replicateTypeHashMap;

    public StrategyReplicationUseCase(BasicInformationGateway basicInformationGateway,
                                      DetailReplicationGateway detailReplicationGateway,
                                      List<StrategyReplication> strategyReplications) {
        this.basicInformationGateway = basicInformationGateway;
        this.detailReplicationGateway = detailReplicationGateway;
        this.replicateTypeHashMap = strategyReplications.stream()
                .collect(Collectors.toMap(
                        StrategyReplication::getReplicateType,
                        Function.identity()
                ));
    }

    public void replicate(String event) {
        AtomicReference<DetailReplication> detailRef = new AtomicReference<>();

        try {
            // 1. Parsear evento
            String idEvent = Optional.ofNullable(XMLParser.getIdEventoAsMap(event))
                    .orElseThrow(() -> new ReplicationException(Errors.NO_FOUND_EVENT));

            // 2. Buscar DetailReplication
            DetailReplication detail = Optional.ofNullable(detailReplicationGateway.findByIdEvent(idEvent))
                    .orElseThrow(() -> new ReplicationException(Errors.NO_DETAIL_REPLICATION_FOUND + idEvent));
            detailRef.set(detail);

            // 3. Validar tipo y número de documento
            if (detail.getDocumentType() == null || detail.getDocumentNumber() == null) {
                throw new ReplicationException(Errors.NO_BASIC_INFORMATION_FOUND +
                        detail.getDocumentType() + Errors.AND_DOCUMENT_NUMBER + detail.getDocumentNumber());
            }

            // 4. Obtener BasicInformation
            BasicInformation info = Optional.ofNullable(basicInformationGateway.getBasicInformation(
                            detail.getDocumentType(), detail.getDocumentNumber()))
                    .orElseThrow(() -> new ReplicationException(Errors.NO_BASIC_INFORMATION_FOUND +
                            detail.getDocumentType() + Errors.AND_DOCUMENT_NUMBER + detail.getDocumentNumber()))
                    .toBuilder()
                    .informationToReplicate(detail.getInformationToReplicate())
                    .build();


            // 5. Validar ID Config
            if (detail.getIdConfig() == null) {
                throw new ReplicationException(Errors.NO_ID_CONFIG);
            }

            // 6. Obtener tipo de replicación y estrategia
            ReplicateType replicateType = Arrays.stream(ReplicateType.values())
                    .filter(type -> detail.getIdConfig().equalsIgnoreCase(type.getValue()))
                    .findFirst()
                    .orElseThrow(() -> new ReplicationException(NO_STRATEGY_FOUND + detail.getIdConfig()));

            StrategyReplication strategy = replicateTypeHashMap.get(replicateType);
            if (strategy == null) {
                throw new ReplicationException(NO_STRATEGY_FOUND + detail.getIdConfig());
            }

            // 7. Ejecutar replicación
            logger.info("UserId: {}", info.getUserId());

            strategyValidate(strategy, info, replicateType);


            // 8. Actualizar estado exitoso
            detailReplicationGateway.updateStatus(detail.toBuilder()
                    .state(State.PROCESSED)
                    .description("Replication successful")
                    .build());

        } catch (ReplicationException e) {
            logger.error("Replication error for detail: {}. Error: {}", detailRef.get(), e.getMessage());
            updateStatusIfDetailPresent(detailRef.get(), e.getMessage());
        } catch (Exception e) {
            logger.error("Unexpected error during replication for detail: {}. Error: {}", detailRef.get(), e.getMessage());
            updateStatusIfDetailPresent(detailRef.get(), "Unexpected error: " + e.getMessage());
        }
    }

    private static void strategyValidate(StrategyReplication strategy, BasicInformation info, ReplicateType replicateType) {
        try {
            strategy.replicate(info);
        } catch (Exception e) {
            throw new ReplicationException("Error replicating with strategy [" +
                    replicateType.name() + "]: " + e.getMessage());
        }
    }

    private void updateStatusIfDetailPresent(DetailReplication detail, String description) {
        if (detail != null) {
            detailReplicationGateway.updateStatus(detail.toBuilder()
                    .state(State.ERROR)
                    .description(description)
                    .build());
        }
    }
}


