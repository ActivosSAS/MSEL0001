package com.co.activos.msel0001.infrastructure.drivenAdapters.firestore.agreementData;

import com.google.cloud.spring.data.firestore.FirestoreReactiveRepository;
import reactor.core.publisher.Mono;

public interface AgreementDataRepository extends FirestoreReactiveRepository<AgreementData> {
    Mono<AgreementData> findByUserId(String userId);
}
