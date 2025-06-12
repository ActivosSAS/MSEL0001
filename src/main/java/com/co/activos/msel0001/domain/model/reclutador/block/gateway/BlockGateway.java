package com.co.activos.msel0001.domain.model.reclutador.block.gateway;

import com.co.activos.msel0001.domain.model.reclutador.block.Block;

public interface BlockGateway {
    void saveBlock(Block block);
    Block getBlock(String userId);
}
