package com.co.activos.msel0001.domain.model.reclutador.userDocumentary.gateway;

import com.co.activos.msel0001.domain.model.reclutador.userDocumentary.UserDocumentaryReview;

public interface UserDocumentaryGateway {

    UserDocumentaryReview findByUserId(String userId);

    void saveUserDocumentary(UserDocumentaryReview userDocumentaryReview);
}
