package com.co.activos.msel0001.infrastructure.drivenAdapters.firestore.remarkData.Converter;

import com.co.activos.msel0001.domain.model.reclutador.remark.Remark;
import com.co.activos.msel0001.infrastructure.drivenAdapters.firestore.remarkData.RemarkData;

public class RemarkConverter {

    public static RemarkData toRemarkData(Remark remark) {
        return RemarkData.builder()
                .id(remark.getId())
                .userId(remark.getUserId())
                .mark(remark.getMark())
                .build();
    }

    public static Remark toRemark(RemarkData remarkData) {
        return Remark.builder()
                .id(remarkData.getId())
                .userId(remarkData.getUserId())
                .mark(remarkData.getMark())
                .build();
    }
}
