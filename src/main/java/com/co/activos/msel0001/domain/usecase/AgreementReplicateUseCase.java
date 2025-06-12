package com.co.activos.msel0001.domain.usecase;

import com.co.activos.msel0001.domain.exceptions.ReplicationException;
import com.co.activos.msel0001.domain.model.reclutador.agreement.Agreement;
import com.co.activos.msel0001.domain.model.reclutador.agreement.gateway.AgreementGateway;
import com.co.activos.msel0001.domain.model.reclutador.basicInformation.BasicInformation;
import com.co.activos.msel0001.domain.model.strategy.ReplicateType;
import com.co.activos.msel0001.domain.model.strategy.StrategyReplication;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AgreementReplicateUseCase implements StrategyReplication {


    private final Gson gson;
    private final AgreementGateway agreementGateway;

    @Override
    public void replicate(BasicInformation information) {

        Agreement agreementToSave = buildAgreement(information)
                .toBuilder()
                .userId(information.getUserId())
                .build();

        Agreement existingAgreement = agreementGateway.findByUserId(information.getUserId());

        if (existingAgreement != null) {
            Agreement updated = updateAgreement(existingAgreement, agreementToSave);
            if (existingAgreement.equals(updated)) {
                return;
            }
            agreementToSave = updated;
        }
        agreementGateway.saveAgreement(agreementToSave);
    }

    @Override
    public ReplicateType getReplicateType() {
        return ReplicateType.AGGREGATE;
    }

    private Agreement buildAgreement(BasicInformation information) {
        try {
            return gson.fromJson(information.getInformationToReplicate(), Agreement.class);
        } catch (JsonSyntaxException e) {
            throw new ReplicationException("Invalid JSON format for Block: " + information.getInformationToReplicate(), e);
        }
    }

    private Agreement updateAgreement(Agreement existingAgreement, Agreement newAgreement) {

        return existingAgreement.toBuilder()
                .id(existingAgreement.getId())
                .userId(newAgreement.getUserId())
                .agreementId(newAgreement.getAgreementId())
                .status(newAgreement.getStatus())
                .build();
    }


}
