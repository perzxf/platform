package com.jb.mapper.seller;


import com.jb.model.BillOfMaterials;
import com.jb.model.CustomMadePr;
import com.jb.model.TChannel;
import com.jb.model.TMaterial;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface MaterialMapper {

    int queryCustomMadePrCount(HashMap<String, Object> params);

    List<CustomMadePr> queryCustomMadePrPageList(HashMap<String, Object> params);

    List<CustomMadePr> queryCxyCustomMadePr(String id);

    void deleteCxyCustomMadePr(String id);

    void updateCxyCustomMadePr(CustomMadePr customMadePr);

    void updateBillOfMaterials(BillOfMaterials billOfMaterials);

    List<TChannel> queryTChannelList();

    void updateCount(TMaterial tMaterial);

   void updateBrand(TMaterial tMaterial);

    void updateUnitprice(TMaterial tMaterial);


    void delServiceQuotation(String id);
}
