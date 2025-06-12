package com.co.activos.msel0001.domain.model.reclutador.basicInformation.gateway;

import com.co.activos.msel0001.domain.model.reclutador.basicInformation.BasicInformation;

public interface BasicInformationGateway {
    BasicInformation getBasicInformation(String typeDocument, String documentNumber);
}
