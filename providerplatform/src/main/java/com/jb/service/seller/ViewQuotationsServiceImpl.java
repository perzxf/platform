package com.jb.service.seller;


import com.jb.mapper.seller.ViewQuotationsMapper;
import com.jb.model.TMaterial;
import com.jb.model.TServiceQuotation;
import com.jb.util.PageResult;
import com.jb.util.PageUtil;
import com.jb.util.PageUtilEasyui;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ViewQuotationsServiceImpl implements IViewQuotationsService{

    @Autowired
    private ViewQuotationsMapper viewQuotationsMapper;

    @Override
    public PageResult queryMaterial(PageUtilEasyui<TMaterial> page) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("material",page.getT());
        Integer count=viewQuotationsMapper.queryMaterialCount(map);
        PageUtil<TMaterial> pageUtil = new PageUtil<>(count, page.getPage(),page.getRows());
        map.put("break",pageUtil.getStartIndex());
        map.put("rows",page.getRows());
        List<TMaterial> list=viewQuotationsMapper.queryMaterial(map);
        PageResult re = new PageResult();
        re.setRows(list);
        re.setTotal(count);
        return re;
    }

    @Override
    public List<TServiceQuotation> queryTServiceQuotation(TServiceQuotation tServiceQuotation) {
        return viewQuotationsMapper.queryTServiceQuotation(tServiceQuotation);
    }

    @Override
    public void updateTMaterial(List<TMaterial> tMaterial) {
        for (Integer i=0;i<tMaterial.size();i++){
            System.out.println(tMaterial.get(i));
            viewQuotationsMapper.updateMaterial(tMaterial.get(i));
        }
    }

    @Override
    public void updateService(List<TServiceQuotation> tServiceQuotation) {
        System.out.println(tServiceQuotation.get(0));
        viewQuotationsMapper.deleteService(tServiceQuotation.get(0));
        for (Integer i=0;i<tServiceQuotation.size();i++){
            System.out.println(tServiceQuotation.get(i));
           viewQuotationsMapper.saveService(tServiceQuotation.get(i));
        }
    }

    @Override
    public void updateCustommadepr(TMaterial tMaterial) {
        viewQuotationsMapper.updateCustommadepr(tMaterial);
    }

    @Override
    public void updateMaterialPrice(TMaterial material) {
        viewQuotationsMapper.updateMaterialPrice(material);
    }

    @Override
    public void updateMaterialBrand(TMaterial material) {
        viewQuotationsMapper.updateMaterialBrand(material);
    }

    @Override
    public void updateServicePrice(TServiceQuotation tServiceQuotation) {
        viewQuotationsMapper.updateServicePrice(tServiceQuotation);
    }
}
