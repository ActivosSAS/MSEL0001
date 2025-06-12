package com.co.activos.msel0001.infrastructure.drivenAdapters.firestore.basicInformationData;

import com.google.cloud.spring.data.firestore.Document;
import lombok.*;

import java.io.Serializable;

@Data
@Document(collectionName = "BasicData")
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class BasicData implements Serializable {

    private String id;
    private String userId;
    private String name;
    private String lastName;
    private String documentType;
    private String noDocument;
}
