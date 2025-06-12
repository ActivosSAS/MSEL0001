package com.co.activos.msel0001.domain.model.reclutador.block;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Block {
    private final String id;
    private final String cause;
    private final String company;
    private final String companyDocumentNumber;
    private final String companyDocumentType;
    private final String description;
    private final String lock_type;
    private final Boolean itBlocks;
    private final String userId;
}
