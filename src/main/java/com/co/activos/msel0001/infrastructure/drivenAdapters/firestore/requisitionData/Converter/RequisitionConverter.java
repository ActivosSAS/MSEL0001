package com.co.activos.msel0001.infrastructure.drivenAdapters.firestore.requisitionData.Converter;

import com.co.activos.msel0001.domain.model.reclutador.requisition.Requisition;
import com.co.activos.msel0001.infrastructure.drivenAdapters.firestore.requisitionData.RequisitionData;

public class RequisitionConverter {

    public static RequisitionData toRequisitionData(Requisition requisition) {
        return RequisitionData.builder()
                .id(requisition.getId())
                .userId(requisition.getUserId())
                .requisitionNumber(requisition.getRequisitionNumber())
                .deliveryDate(requisition.getDeliveryDate())
                .selectionStatus(requisition.getSelectionStatus())
                .status(requisition.getStatus())
                .requestDate(requisition.getRequestDate())
                .build();
    }

    public static Requisition toRequisition(RequisitionData requisitionData) {
        return Requisition.builder()
                .id(requisitionData.getId())
                .userId(requisitionData.getUserId())
                .requisitionNumber(requisitionData.getRequisitionNumber())
                .deliveryDate(requisitionData.getDeliveryDate())
                .selectionStatus(requisitionData.getSelectionStatus())
                .status(requisitionData.getStatus())
                .requestDate(requisitionData.getRequestDate())
                .build();
    }

}
