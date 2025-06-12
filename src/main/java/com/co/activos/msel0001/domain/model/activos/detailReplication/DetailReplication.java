package com.co.activos.msel0001.domain.model.activos.detailReplication;

import com.co.activos.msel0001.domain.model.activos.detailReplication.util.State;
import lombok.Builder;
import lombok.Data;


@Data
@Builder(toBuilder = true)
public class DetailReplication {
    private final String idEvent;
    private final State state;
    private final String idConfig;
    private final String informationToReplicate;
    private final String date;
    private final String user;
    private final String documentType;
    private final String documentNumber;
    private final String description;
}
