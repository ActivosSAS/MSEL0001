package com.co.activos.msel0001.infrastructure.drivenAdapters.firestore.remarkData;

import com.co.activos.msel0001.domain.model.reclutador.remark.Remark;
import com.co.activos.msel0001.domain.model.reclutador.remark.gateway.RemarkGateway;
import com.co.activos.msel0001.infrastructure.drivenAdapters.firestore.remarkData.Converter.RemarkConverter;
import org.springframework.stereotype.Repository;

@Repository
public class RemarkRepositoryAdapter implements RemarkGateway {


    private final RemarkDataRepository remarkDataRepository;

    public RemarkRepositoryAdapter(RemarkDataRepository remarkDataRepository) {
        this.remarkDataRepository = remarkDataRepository;
    }

    @Override
    public Remark save(Remark remark) {
        return remarkDataRepository.save(RemarkConverter.toRemarkData(remark))
                .map(RemarkConverter::toRemark)
                .block();

    }

    @Override
    public Remark findByUserId(String id) {
        return remarkDataRepository.findByUserId(id)
                .map(RemarkConverter::toRemark)
                .block();
    }
}
