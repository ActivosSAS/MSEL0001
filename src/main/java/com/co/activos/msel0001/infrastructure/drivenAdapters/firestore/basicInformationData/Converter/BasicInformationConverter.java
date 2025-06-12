package com.co.activos.msel0001.infrastructure.drivenAdapters.firestore.basicInformationData.Converter;

import com.co.activos.msel0001.domain.model.reclutador.basicInformation.BasicInformation;
import com.co.activos.msel0001.infrastructure.drivenAdapters.firestore.basicInformationData.BasicData;

public class BasicInformationConverter {

    public static BasicInformation convertToDomain(BasicData basicInformationData) {
        return BasicInformation.builder()
                .id(basicInformationData.getId())
                .userId(basicInformationData.getUserId())
                .documentType(basicInformationData.getDocumentType())
                .documentNumber(basicInformationData.getNoDocument())
                .name(basicInformationData.getName())
                .lastName(basicInformationData.getLastName())
                .build();
    }


}
