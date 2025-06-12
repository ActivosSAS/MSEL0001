package com.co.activos.msel0001.infrastructure.drivenAdapters.firestore.agreementData;

import com.co.activos.msel0001.domain.model.reclutador.agreement.Agreement;
import com.co.activos.msel0001.domain.model.reclutador.agreement.gateway.AgreementGateway;
import com.co.activos.msel0001.infrastructure.drivenAdapters.firestore.agreementData.Converter.AgreementConverter;
import org.springframework.stereotype.Repository;

@Repository
public class AgreementRepositoryAdapter implements AgreementGateway {

    private final AgreementDataRepository agreementDataRepository;

    public AgreementRepositoryAdapter(AgreementDataRepository agreementDataRepository) {
        this.agreementDataRepository = agreementDataRepository;
    }

    @Override
    public Agreement findByUserId(String userId) {
        return agreementDataRepository.findByUserId(userId)
                .map(AgreementConverter::buildToDomain)
                .block();
    }

    @Override
    public void saveAgreement(Agreement agreement) {
        agreementDataRepository
                .save(AgreementConverter.buildToData(agreement))
                .block();
    }
}
