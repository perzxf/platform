package com.jb.mapper.seller;

import com.jb.model.TMaterial;
import com.jb.model.TServiceQuotation;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface ViewQuotationsMapper {

    Integer queryMaterialCount(HashMap<String, Object> map);

    List<TMaterial> queryMaterial(HashMap<String, Object> map);

    List<TServiceQuotation> queryTServiceQuotation(TServiceQuotation tServiceQuotation);

    void updateMaterial(TMaterial tMaterial);

    void deleteService(TServiceQuotation tServiceQuotation);

    void saveService(TServiceQuotation tServiceQuotation);

    void updateCustommadepr(TMaterial tMaterial);

    void updateMaterialPrice(TMaterial material);

    void updateMaterialBrand(TMaterial material);

    void updateServicePrice(TServiceQuotation tServiceQuotation);
}
