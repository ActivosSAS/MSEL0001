package com.co.activos.msel0001.infrastructure.drivenAdapters.firestore.agreementData.Converter;

import com.co.activos.msel0001.domain.model.reclutador.agreement.Agreement;
import com.co.activos.msel0001.infrastructure.drivenAdapters.firestore.agreementData.AgreementData;

public class AgreementConverter {

    public static AgreementData buildToData(Agreement agreement) {
        return AgreementData
                .builder()
                .id(agreement.getId())
                .agreementId(agreement.getAgreementId())
                .status(agreement.getStatus())
                .userId(agreement.getUserId())
                .build();
    }

    public static Agreement buildToDomain(AgreementData agreementData) {
        return Agreement
                .builder()
                .id(agreementData.getId())
                .agreementId(agreementData.getAgreementId())
                .status(agreementData.getStatus())
                .userId(agreementData.getUserId())
                .build();
    }
}
