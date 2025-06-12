package com.co.activos.msel0001.domain.usecase;

import com.co.activos.msel0001.domain.model.reclutador.basicInformation.BasicInformation;
import com.co.activos.msel0001.domain.model.reclutador.block.Block;
import com.co.activos.msel0001.domain.model.reclutador.block.gateway.BlockGateway;
import com.co.activos.msel0001.domain.model.strategy.ReplicateType;
import com.co.activos.msel0001.domain.model.strategy.StrategyReplication;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import org.springframework.stereotype.Service;

@Service
public class BlockReplicateUseCase implements StrategyReplication {

    private final Gson gson;
    private final BlockGateway blockGateway;

    public BlockReplicateUseCase(Gson gson, BlockGateway blockGateway) {
        this.gson = gson;
        this.blockGateway = blockGateway;

    }

    @Override
    public void replicate(BasicInformation information) {

        Block blockToSave = buildBlock(information)
                .toBuilder()
                .userId(information.getUserId())
                .build();

        Block existingBlock = blockGateway.getBlock(information.getUserId());

        if (existingBlock != null) {
            blockToSave = updateBlock(existingBlock, blockToSave);
        }

        blockGateway.saveBlock(blockToSave);
    }

    private Block buildBlock(BasicInformation information) {
        try {
            return gson.fromJson(information.getInformationToReplicate(), Block.class);
        } catch (JsonSyntaxException e) {
            throw new IllegalArgumentException("Invalid JSON format for Block: " + information.getInformationToReplicate(), e);
        }
    }

    private Block updateBlock(Block existingBlock, Block newBlock) {

        return existingBlock.toBuilder()
                .id(existingBlock.getId())
                .userId(newBlock.getUserId())
                .itBlocks(newBlock.getItBlocks())
                .cause(newBlock.getCause())
                .lock_type(newBlock.getLock_type())
                .description(newBlock.getDescription())
                .companyDocumentType(newBlock.getCompanyDocumentType())
                .companyDocumentNumber(newBlock.getCompanyDocumentNumber())
                .company(newBlock.getCompany())
                .build();
    }

    @Override
    public ReplicateType getReplicateType() {
        return ReplicateType.BLOCK;
    }
}
