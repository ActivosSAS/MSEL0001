package com.co.activos.msel0001.infrastructure.drivenAdapters.firestore.requisitionData;

import com.google.cloud.firestore.annotation.DocumentId;
import com.google.cloud.spring.data.firestore.Document;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@Document(collectionName = "RequisitionData")
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class RequisitionData implements Serializable {

    @DocumentId
    private  String id;
    private  String userId;
    private  String requisitionNumber;
    private  String deliveryDate;
    private  String requestDate;
    private  String selectionStatus;
    private  String status;
}
