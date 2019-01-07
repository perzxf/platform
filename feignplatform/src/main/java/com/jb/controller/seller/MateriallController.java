package com.jb.controller.seller;

import com.jb.model.TMaterial;
import com.jb.model.TServiceQuotation;
import com.jb.service.MaterialService;
import com.jb.util.PageResult;
import com.jb.util.PageUtilEasyui;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MateriallController {

    @Autowired
    private MaterialService materialService;

    @RequestMapping("queryMaterial")
    @ResponseBody
    public PageResult queryMaterial(PageUtilEasyui<TMaterial> page, TMaterial material){
        page.setT(material);
        return materialService.queryMaterial(page);
    }

    @RequestMapping("queryTServiceQuotation")
    @ResponseBody
    public List<TServiceQuotation> queryTServiceQuotation(TServiceQuotation tServiceQuotation){
        return materialService.queryTServiceQuotation(tServiceQuotation);
    }

    @RequestMapping("updateMaterialPriceAndbander")
    @ResponseBody
    public void updateMaterialPriceAndbander(TMaterial material){
        materialService.updateMaterialPriceAndbander(material);
    }

    @RequestMapping("updateMaterialBrand")
    @ResponseBody
    public void updateMaterialBrand(TMaterial material){
        materialService.updateMaterialBrand(material);
    }

    @RequestMapping("updateServicePrice")
    @ResponseBody
    public void updateServicePrice(TServiceQuotation tServiceQuotation){
        materialService.updateServicePrice(tServiceQuotation);
    }



}
