package com.co.activos.msel0001.domain.model.strategy;

import lombok.Getter;

@Getter
public enum ReplicateType {

    AGGREGATE("8"),
    BLOCK("6"),
    REMARK("5"),
    REQUISITION("7"),
    USER_DOCUMENTARY("11"),
    BASIC_INFORMATION("10");

    private final String value;

    ReplicateType(String value) {
        this.value = value;
    }

}
