package com.jb.service.seller;

import com.jb.model.BillOfMaterials;
import com.jb.model.CustomMadePr;
import com.jb.model.TChannel;
import com.jb.model.TMaterial;
import com.jb.util.PageResult;
import com.jb.util.PageUtilEasyui;

import java.util.List;

public interface MaterialService {

    PageResult queryCustomMadePr(PageUtilEasyui<CustomMadePr> pageUtilEasyui);

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
