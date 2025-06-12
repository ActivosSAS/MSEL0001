package com.co.activos.msel0001.infrastructure.drivenAdapters.Oracle.detailReplication;


import com.co.activos.msel0001.domain.model.activos.detailReplication.DetailReplication;
import com.co.activos.msel0001.domain.model.activos.detailReplication.gateway.DetailReplicationGateway;
import com.co.activos.msel0001.infrastructure.drivenAdapters.Oracle.detailReplication.Converter.DetailReplicationConverter;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class DetailReplicationRepositoryAdapter implements DetailReplicationGateway {

    private final DetailReplicationRepository detailReplicationRepository;

    public DetailReplicationRepositoryAdapter(DetailReplicationRepository detailReplicationRepository) {
        this.detailReplicationRepository = detailReplicationRepository;
    }

    @Override
    public DetailReplication findByIdEvent(String id) {
        return detailReplicationRepository.findById(id)
                .map(DetailReplicationConverter::convertToDomain)
                .orElse(null);
    }

    @Transactional
    @Override
    public void updateStatus(DetailReplication detailReplication) {
        detailReplicationRepository
                .save(DetailReplicationConverter.convertToEntity(detailReplication));
    }


}
