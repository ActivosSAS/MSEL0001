package com.co.activos.msel0001.domain.model.reclutador.agreement.gateway;

import com.co.activos.msel0001.domain.model.reclutador.agreement.Agreement;

public interface AgreementGateway {
    Agreement findByUserId(String userId);
    void saveAgreement(Agreement agreement);
}
