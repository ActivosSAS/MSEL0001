package com.co.activos.msel0001.infrastructure.drivenAdapters.Oracle.detailReplication;

import lombok.*;

import javax.persistence.*;


@Data
@AllArgsConstructor
@Table(name = "Replication_Detail", schema = "RHU")
@Entity
@Builder(toBuilder = true)
@NoArgsConstructor
public class DetailReplicationData {

    @Id
    @Column(name = "ID_RD")
    private String idEvent;

    @Column(name = "STATE_RD")
    private String state; // PENDIENTE, PROCESADO, ERROR

    @Column(name = "DATA_JSON")
    private String informationToReplicate;


    @Column(name = "DATE_RD")
    private String date;

    @Column(name = "USER_RD")
    private String user;

    @Column(name = "DOCUMENT_TYPE")
    private String documentType;

    @Column(name = "DOCUMENT_NUMBER")
    private String documentNumber;

    @Column(name = "ID_CONFIG")
    private String idConfig;

    @Column(name = "DESCRIPTION_RD")
    private String description;


}
