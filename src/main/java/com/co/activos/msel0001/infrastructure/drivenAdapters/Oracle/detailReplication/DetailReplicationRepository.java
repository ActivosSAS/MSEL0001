package com.co.activos.msel0001.infrastructure.drivenAdapters.Oracle.detailReplication;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailReplicationRepository extends JpaRepository<DetailReplicationData, String> {
  DetailReplicationData findByIdEvent(String id);
}
