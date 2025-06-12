package com.co.activos.msel0001.infrastructure.drivenAdapters.firestore.requisitionData;

import com.google.cloud.spring.data.firestore.FirestoreReactiveRepository;
import reactor.core.publisher.Mono;

public interface RequisitionDataRepository extends FirestoreReactiveRepository<RequisitionData> {
    Mono<RequisitionData> findByUserId(String userId);
}
