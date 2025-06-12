package com.co.activos.msel0001.infrastructure.drivenAdapters.firestore.blockData;

import com.co.activos.msel0001.domain.model.reclutador.block.Block;
import com.co.activos.msel0001.domain.model.reclutador.block.gateway.BlockGateway;
import com.co.activos.msel0001.infrastructure.drivenAdapters.firestore.blockData.Converter.BlockDataConverter;
import org.springframework.stereotype.Repository;

import static com.co.activos.msel0001.infrastructure.drivenAdapters.firestore.blockData.Converter.BlockDataConverter.buildToData;

@Repository
public class BlockRepositoryAdapter implements BlockGateway {

    private final BlockDataRepository blockDataRepository;

    public BlockRepositoryAdapter(BlockDataRepository blockDataRepository) {
        this.blockDataRepository = blockDataRepository;
    }

    @Override
    public void saveBlock(Block block) {
        blockDataRepository.save(buildToData(block))
                .block();
    }


    @Override
    public Block getBlock(String userId) {
        return blockDataRepository.findByUserId(userId)
                .map(BlockDataConverter::buildToDomain)
                .block();
    }

}
