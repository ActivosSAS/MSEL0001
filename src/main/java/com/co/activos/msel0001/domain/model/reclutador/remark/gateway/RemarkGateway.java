package com.co.activos.msel0001.domain.model.reclutador.remark.gateway;

import com.co.activos.msel0001.domain.model.reclutador.remark.Remark;

public interface RemarkGateway {
    Remark save(Remark remark);
    Remark findByUserId(String id);
}
