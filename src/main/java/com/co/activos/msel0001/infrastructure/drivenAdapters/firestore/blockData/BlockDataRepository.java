package com.co.activos.msel0001.infrastructure.drivenAdapters.firestore.blockData;

import com.google.cloud.spring.data.firestore.FirestoreReactiveRepository;
import reactor.core.publisher.Mono;

public interface BlockDataRepository extends FirestoreReactiveRepository<BlockData> {
    Mono<BlockData> findByUserId(String userId);
}
