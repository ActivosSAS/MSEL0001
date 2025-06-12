package com.co.activos.msel0001.domain.model.reclutador.remark;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder(toBuilder = true)
public class Remark {
    private final String id;
    private final String userId;
    private final String mark;
    private final String score;
}
