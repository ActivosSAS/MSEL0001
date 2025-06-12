package com.co.activos.msel0001.domain.model.reclutador.userDocumentary;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;



@Data
@AllArgsConstructor
@Builder(toBuilder = true)
public class UserDocumentaryReview {
    private final String id;
    private final String userId;
    private final String requisitionNumber;
    private final String updateDate;
}
