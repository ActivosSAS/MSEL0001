package com.co.activos.msel0001.infrastructure.drivenAdapters.Oracle.detailReplication.Converter;

import com.co.activos.msel0001.domain.model.activos.detailReplication.DetailReplication;
import com.co.activos.msel0001.domain.model.activos.detailReplication.util.State;
import com.co.activos.msel0001.infrastructure.drivenAdapters.Oracle.detailReplication.DetailReplicationData;


import java.text.SimpleDateFormat;
import java.util.Date;


public class DetailReplicationConverter {


    public static DetailReplication convertToDomain(DetailReplicationData detailReplicationData) {
        return DetailReplication
                .builder()
                .idEvent(detailReplicationData.getIdEvent())
                .date(detailReplicationData.getDate())
                .documentNumber(detailReplicationData.getDocumentNumber())
                .documentType(detailReplicationData.getDocumentType())
                .idConfig(detailReplicationData.getIdConfig())
                .informationToReplicate(detailReplicationData.getInformationToReplicate())
                .state(State.valueOf(detailReplicationData.getState().toUpperCase()))
                .user(detailReplicationData.getUser())
                .description(detailReplicationData.getDescription())
                .build();
    }


    public static DetailReplicationData convertToEntity(DetailReplication detailReplication) {
        return DetailReplicationData
                .builder()
                .idEvent(detailReplication.getIdEvent())
                .date(getDate())
                .documentNumber(detailReplication.getDocumentNumber())
                .documentType(detailReplication.getDocumentType())
                .idConfig(detailReplication.getIdConfig())
                .informationToReplicate(detailReplication.getInformationToReplicate())
                .state(detailReplication.getState().name())
                .user(detailReplication.getUser())
                .description(detailReplication.getDescription())
                .build();
    }

    private static String getDate() {
        String pattern = "yyyy-MM-dd HH:mm:ss"; // Sin milisegundos
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String dateFormat = simpleDateFormat.format(new Date());
        return dateFormat;
    }
}
