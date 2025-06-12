package com.co.activos.msel0001.domain.usecase;

import com.co.activos.msel0001.domain.model.reclutador.basicInformation.BasicInformation;
import com.co.activos.msel0001.domain.model.reclutador.userDocumentary.UserDocumentaryReview;
import com.co.activos.msel0001.domain.model.reclutador.userDocumentary.gateway.UserDocumentaryGateway;
import com.co.activos.msel0001.domain.model.strategy.ReplicateType;
import com.co.activos.msel0001.domain.model.strategy.StrategyReplication;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDocumentaryReplicateUseCase implements StrategyReplication {

    private final Gson gson;
    private final UserDocumentaryGateway userDocumentaryGateway;

    @Override
    public void replicate(BasicInformation information) {
        UserDocumentaryReview userDocumentaryReviewToSave = buildUserDocumentaryReview(information)
                .toBuilder()
                .userId(information.getUserId())
                .build();

        UserDocumentaryReview existingUserDocumentaryReview = userDocumentaryGateway.findByUserId(information.getUserId());

        if (existingUserDocumentaryReview != null) {
            userDocumentaryReviewToSave = updateUserDocumentaryReview(existingUserDocumentaryReview, userDocumentaryReviewToSave);
        }

        userDocumentaryGateway.saveUserDocumentary(userDocumentaryReviewToSave);
    }

    @Override
    public ReplicateType getReplicateType() {
        return ReplicateType.USER_DOCUMENTARY;
    }


    private UserDocumentaryReview buildUserDocumentaryReview(BasicInformation information) {
        try {
            return gson.fromJson(information.getInformationToReplicate(), UserDocumentaryReview.class);
        } catch (JsonSyntaxException e) {
            throw new IllegalArgumentException("Invalid JSON format for Block: " + information.getInformationToReplicate(), e);
        }
    }

    private UserDocumentaryReview updateUserDocumentaryReview(UserDocumentaryReview existingUserDocumentaryReview, UserDocumentaryReview newUserDocumentaryReview) {

        return existingUserDocumentaryReview.toBuilder()
                .id(existingUserDocumentaryReview.getId())
                .userId(newUserDocumentaryReview.getUserId())
                .requisitionNumber(newUserDocumentaryReview.getRequisitionNumber())
                .updateDate(newUserDocumentaryReview.getUpdateDate())
                .build();
    }
}
