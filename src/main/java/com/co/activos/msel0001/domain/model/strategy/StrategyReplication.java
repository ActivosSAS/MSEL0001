package com.co.activos.msel0001.domain.model.strategy;

import com.co.activos.msel0001.domain.model.reclutador.basicInformation.BasicInformation;

public interface StrategyReplication {

    void replicate(BasicInformation information);

    ReplicateType getReplicateType();
}
