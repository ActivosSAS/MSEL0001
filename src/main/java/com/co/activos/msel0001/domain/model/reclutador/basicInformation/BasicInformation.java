package com.co.activos.msel0001.domain.model.reclutador.basicInformation;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class BasicInformation {
    private final String id;
    private final String userId;
    private final String name;
    private final String lastName;
    private final String documentType;
    private final String documentNumber;
    private final String informationToReplicate;
}
