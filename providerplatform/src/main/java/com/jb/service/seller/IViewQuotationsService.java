package com.jb.service.seller;

import com.jb.model.TMaterial;
import com.jb.model.TServiceQuotation;
import com.jb.util.PageResult;
import com.jb.util.PageUtilEasyui;

import java.util.List;

public interface IViewQuotationsService {
    PageResult queryMaterial(PageUtilEasyui<TMaterial> page);

    List<TServiceQuotation> queryTServiceQuotation(TServiceQuotation tServiceQuotation);

    void updateTMaterial(List<TMaterial> tMaterial);

    void updateService(List<TServiceQuotation> tServiceQuotation);

    void updateCustommadepr(TMaterial tMaterial);

    void updateMaterialPrice(TMaterial material);

    void updateMaterialBrand(TMaterial material);

    void updateServicePrice(TServiceQuotation tServiceQuotation);
}
