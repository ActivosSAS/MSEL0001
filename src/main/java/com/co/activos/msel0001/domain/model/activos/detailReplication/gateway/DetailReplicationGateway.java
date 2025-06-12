package com.co.activos.msel0001.domain.model.activos.detailReplication.gateway;

import com.co.activos.msel0001.domain.model.activos.detailReplication.DetailReplication;

public interface DetailReplicationGateway {
  DetailReplication findByIdEvent(String id);
  void updateStatus(DetailReplication detailReplication);
}
