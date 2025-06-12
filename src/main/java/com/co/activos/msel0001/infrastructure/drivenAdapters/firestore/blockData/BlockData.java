package com.co.activos.msel0001.infrastructure.drivenAdapters.firestore.blockData;

import com.google.cloud.firestore.annotation.DocumentId;
import com.google.cloud.spring.data.firestore.Document;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Document(collectionName = "BlockData")
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class BlockData implements Serializable {

    @DocumentId
    private String id;
    private String cause;
    private String company;
    private String companyDocumentNumber;
    private String companyDocumentType;
    private String description;
    private Boolean itBlocks;
    private String lock_type;
    private String userId;
}
