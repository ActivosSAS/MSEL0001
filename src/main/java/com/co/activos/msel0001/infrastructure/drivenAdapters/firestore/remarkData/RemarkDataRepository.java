package com.co.activos.msel0001.infrastructure.drivenAdapters.firestore.remarkData;

import com.google.cloud.spring.data.firestore.FirestoreReactiveRepository;
import reactor.core.publisher.Mono;

public interface RemarkDataRepository extends FirestoreReactiveRepository<RemarkData> {

    Mono<RemarkData> findByUserId(String userId);
}
