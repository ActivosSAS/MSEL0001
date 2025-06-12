package com.co.activos.msel0001.infrastructure.drivenAdapters.firestore.userDocumentaryReviewData;

import com.co.activos.msel0001.domain.model.reclutador.userDocumentary.UserDocumentaryReview;
import com.co.activos.msel0001.domain.model.reclutador.userDocumentary.gateway.UserDocumentaryGateway;
import com.co.activos.msel0001.infrastructure.drivenAdapters.firestore.userDocumentaryReviewData.Converter.UserDocumentaryConverter;
import org.springframework.stereotype.Repository;

@Repository
public class UserDocumentaryReviewRepositoryAdapter implements UserDocumentaryGateway {

    private final UserDocumentaryReviewDataRepository userDocumentaryReviewDataRepository;

    public UserDocumentaryReviewRepositoryAdapter(UserDocumentaryReviewDataRepository userDocumentaryReviewDataRepository) {
        this.userDocumentaryReviewDataRepository = userDocumentaryReviewDataRepository;
    }

    @Override
    public UserDocumentaryReview findByUserId(String userId) {
        return userDocumentaryReviewDataRepository.findByUserId(userId)
                .map(UserDocumentaryConverter::toUserDocumentaryReview)
                .block();
    }

    @Override
    public void saveUserDocumentary(UserDocumentaryReview userDocumentaryReview) {
        userDocumentaryReviewDataRepository
                .save(UserDocumentaryConverter.toUserDocumentaryReviewData(userDocumentaryReview))
                .block();

    }
}
