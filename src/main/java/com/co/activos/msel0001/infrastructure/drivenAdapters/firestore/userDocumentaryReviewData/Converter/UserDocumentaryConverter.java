package com.co.activos.msel0001.infrastructure.drivenAdapters.firestore.userDocumentaryReviewData.Converter;

import com.co.activos.msel0001.domain.model.reclutador.userDocumentary.UserDocumentaryReview;
import com.co.activos.msel0001.infrastructure.drivenAdapters.firestore.userDocumentaryReviewData.UserDocumentaryReviewData;

public class UserDocumentaryConverter {

    public static UserDocumentaryReviewData toUserDocumentaryReviewData(UserDocumentaryReview userDocumentaryReview) {
        return UserDocumentaryReviewData.builder()
                .id(userDocumentaryReview.getId())
                .userId(userDocumentaryReview.getUserId())
                .requisitionNumber(userDocumentaryReview.getRequisitionNumber())
                .updateDate(userDocumentaryReview.getUpdateDate())
                .build();
    }

    public static UserDocumentaryReview toUserDocumentaryReview(UserDocumentaryReviewData userDocumentaryReviewData) {
        return UserDocumentaryReview.builder()
                .id(userDocumentaryReviewData.getId())
                .userId(userDocumentaryReviewData.getUserId())
                .requisitionNumber(userDocumentaryReviewData.getRequisitionNumber())
                .updateDate(userDocumentaryReviewData.getUpdateDate())
                .build();
    }
}
