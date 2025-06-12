package com.co.activos.msel0001.infrastructure.drivenAdapters.firestore.basicInformationData;

import com.co.activos.msel0001.domain.model.reclutador.basicInformation.BasicInformation;
import com.co.activos.msel0001.domain.model.reclutador.basicInformation.gateway.BasicInformationGateway;
import com.co.activos.msel0001.infrastructure.drivenAdapters.firestore.basicInformationData.Converter.BasicInformationConverter;
import org.springframework.stereotype.Repository;

@Repository
public class BasicRepositoryAdapter implements BasicInformationGateway {

    private final BasicDataRepository basicDataRepository;

    public BasicRepositoryAdapter(BasicDataRepository basicDataRepository) {
        this.basicDataRepository = basicDataRepository;
    }

    @Override
    public BasicInformation getBasicInformation(String typeDocument, String documentNumber) {
        return basicDataRepository.findByDocumentTypeAndNoDocument(typeDocument, documentNumber)
                .map(BasicInformationConverter::convertToDomain)
                .block();


    }
}
