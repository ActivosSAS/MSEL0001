package com.co.activos.msel0001.infrastructure.drivenAdapters.firestore.agreementData;

import com.google.cloud.firestore.annotation.DocumentId;
import com.google.cloud.spring.data.firestore.Document;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Document(collectionName = "AgreementData")
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class AgreementData implements Serializable {

    @DocumentId
    private  String id;
    private  String userId;
    private  String agreementId;
    private  String status;
}
