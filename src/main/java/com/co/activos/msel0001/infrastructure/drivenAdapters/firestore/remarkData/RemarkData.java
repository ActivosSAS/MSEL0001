package com.co.activos.msel0001.infrastructure.drivenAdapters.firestore.remarkData;

import com.google.cloud.firestore.annotation.DocumentId;
import com.google.cloud.spring.data.firestore.Document;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Document(collectionName = "RemarkData")
@Builder(toBuilder = true)
public class RemarkData implements Serializable {

    @DocumentId
    private String id;
    private String userId;
    private String mark;
    private String score;
}
