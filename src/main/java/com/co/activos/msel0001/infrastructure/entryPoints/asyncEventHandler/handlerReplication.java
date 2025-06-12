package com.co.activos.msel0001.infrastructure.entryPoints.asyncEventHandler;

import com.co.activos.msel0001.domain.usecase.StrategyReplicationUseCase;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class handlerReplication {

    private static final Logger logger = LoggerFactory.getLogger(handlerReplication.class);
    private final StrategyReplicationUseCase replicationUseCase;

    @JmsListener(destination = "sq_replication", containerFactory = "jmsListenerContainerFactory")
    public void onMessage(String message) {
        long startTime = System.currentTimeMillis();
        logger.info("Received message: {} ", message);
        replicationUseCase.replicate(message);
        logger.info("Message processed");
        long endTime = System.currentTimeMillis();
        double durationInSeconds = (endTime - startTime) / 1000.0;
        logger.info("Duration: {} seconds", durationInSeconds);
    }
}
