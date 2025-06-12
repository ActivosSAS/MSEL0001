package com.co.activos.msel0001.domain.usecase;

import com.co.activos.msel0001.domain.model.reclutador.basicInformation.BasicInformation;
import com.co.activos.msel0001.domain.model.reclutador.remark.Remark;
import com.co.activos.msel0001.domain.model.reclutador.remark.gateway.RemarkGateway;
import com.co.activos.msel0001.domain.model.strategy.ReplicateType;
import com.co.activos.msel0001.domain.model.strategy.StrategyReplication;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import org.springframework.stereotype.Service;

@Service
public class RemarkReplicateUseCase implements StrategyReplication {

    private final Gson gson;
    private final RemarkGateway remarkGateway;


    public RemarkReplicateUseCase(Gson gson, RemarkGateway remarkGateway) {
        this.gson = gson;
        this.remarkGateway = remarkGateway;
    }

    @Override
    public void replicate(BasicInformation information) {
        Remark remarkToSave = buildRemark(information)
                .toBuilder()
                .userId(information.getUserId())
                .build();

        Remark existingRemark = remarkGateway.findByUserId(information.getUserId());

        if (existingRemark != null) {
            remarkToSave = updateRemark(existingRemark, remarkToSave);
        }

        remarkGateway.save(remarkToSave);
    }

    @Override
    public ReplicateType getReplicateType() {
        return ReplicateType.REMARK;
    }

    private Remark buildRemark(BasicInformation information) {
        try {
            return gson.fromJson(information.getInformationToReplicate(), Remark.class);
        } catch (JsonSyntaxException e) {
            throw new IllegalArgumentException("Invalid JSON format for Block: " + information.getInformationToReplicate(), e);
        }
    }

    private Remark updateRemark(Remark existingRemark, Remark newRemark) {

        return existingRemark.toBuilder()
                .id(existingRemark.getId())
                .userId(newRemark.getUserId())
                .score(newRemark.getScore())
                .mark(newRemark.getMark())
                .build();
    }
}
