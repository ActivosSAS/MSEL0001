package com.co.activos.msel0001.domain.model.reclutador.requisition;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
@Builder(toBuilder = true)
public class Requisition {
    private final String id;
    private final String userId;
    private final String requisitionNumber;
    private final String deliveryDate;
    private final String requestDate;
    private final String selectionStatus;
    private final String status;
}
