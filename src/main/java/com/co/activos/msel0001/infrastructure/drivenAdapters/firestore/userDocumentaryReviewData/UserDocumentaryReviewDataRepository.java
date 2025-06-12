package com.co.activos.msel0001.infrastructure.drivenAdapters.firestore.userDocumentaryReviewData;

import com.google.cloud.spring.data.firestore.FirestoreReactiveRepository;
import reactor.core.publisher.Mono;

public interface UserDocumentaryReviewDataRepository extends FirestoreReactiveRepository<UserDocumentaryReviewData> {
 Mono<UserDocumentaryReviewData> findByUserId(String userId);
}
