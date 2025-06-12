package com.co.activos.msel0001.infrastructure.drivenAdapters.firestore.blockData.Converter;

import com.co.activos.msel0001.domain.model.reclutador.block.Block;
import com.co.activos.msel0001.infrastructure.drivenAdapters.firestore.blockData.BlockData;

public class BlockDataConverter {

    public static BlockData buildToData(Block block) {
        return BlockData
                .builder()
                .id(block.getId())
                .cause(block.getCause())
                .company(block.getCompany())
                .companyDocumentNumber(block.getCompanyDocumentNumber())
                .companyDocumentType(block.getCompanyDocumentType())
                .description(block.getDescription())
                .itBlocks(block.getItBlocks())
                .userId(block.getUserId())
                .lock_type(block.getLock_type())
                .build();
    }

    public static Block buildToDomain(BlockData blockData) {
        return Block
                .builder()
                .id(blockData.getId())
                .cause(blockData.getCause())
                .company(blockData.getCompany())
                .companyDocumentNumber(blockData.getCompanyDocumentNumber())
                .companyDocumentNumber(blockData.getCompanyDocumentNumber())
                .description(blockData.getDescription())
                .itBlocks(blockData.getItBlocks())
                .lock_type(blockData.getLock_type())
                .userId(blockData.getUserId())
                .build();
    }
}
