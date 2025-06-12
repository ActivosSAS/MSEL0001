package com.co.activos.msel0001.domain.model.reclutador.agreement;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Agreement {
    private final String id;
    private final String userId;
    private final String agreementId;
    private final String status;
}
