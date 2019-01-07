package com.jb.service;

import com.jb.model.TMaterial;
import com.jb.model.TServiceQuotation;
import com.jb.util.PageResult;
import com.jb.util.PageUtilEasyui;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@RequestMapping("material")
public interface MaterialService {

    @RequestMapping("queryMaterial")
    PageResult queryMaterial(PageUtilEasyui<TMaterial> page);

    @RequestMapping("queryTServiceQuotation")
    List<TServiceQuotation> queryTServiceQuotation(TServiceQuotation tServiceQuotation);

    @RequestMapping("updateMaterialPriceAndbander")
    void updateMaterialPriceAndbander(TMaterial material);

    @RequestMapping("updateMaterialBrand")
    void updateMaterialBrand(TMaterial material);

    @RequestMapping("updateServicePrice")
    void updateServicePrice(TServiceQuotation tServiceQuotation);
}
