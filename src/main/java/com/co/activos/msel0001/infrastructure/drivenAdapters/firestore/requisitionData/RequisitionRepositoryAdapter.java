package com.co.activos.msel0001.infrastructure.drivenAdapters.firestore.requisitionData;

import com.co.activos.msel0001.domain.model.reclutador.requisition.Requisition;
import com.co.activos.msel0001.domain.model.reclutador.requisition.gateway.RequisitionGateway;
import com.co.activos.msel0001.infrastructure.drivenAdapters.firestore.requisitionData.Converter.RequisitionConverter;
import org.springframework.stereotype.Repository;

@Repository
public class RequisitionRepositoryAdapter implements RequisitionGateway {

    private final RequisitionDataRepository requisitionDataRepository;

    public RequisitionRepositoryAdapter(RequisitionDataRepository requisitionDataRepository) {
        this.requisitionDataRepository = requisitionDataRepository;
    }

    @Override
    public Requisition findByUserId(String id) {
        return requisitionDataRepository.findByUserId(id)
                .map(RequisitionConverter::toRequisition)
                .block();
    }

    @Override
    public Requisition save(Requisition requisition) {
        return requisitionDataRepository
                .save(RequisitionConverter.toRequisitionData(requisition))
                .map(RequisitionConverter::toRequisition)
                .block();
    }
}
