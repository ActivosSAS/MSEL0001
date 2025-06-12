package com.co.activos.msel0001.infrastructure.drivenAdapters.firestore.basicInformationData;

import com.google.cloud.spring.data.firestore.FirestoreReactiveRepository;
import reactor.core.publisher.Mono;


public interface BasicDataRepository extends FirestoreReactiveRepository<BasicData> {
    Mono<BasicData> findByDocumentTypeAndNoDocument(String documentType, String noDocument);

}
