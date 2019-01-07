package com.jb.service;

import com.jb.model.BillOfMaterials;
import com.jb.model.CustomMadePr;
import com.jb.model.TChannel;
import com.jb.model.TMaterial;
import com.jb.util.PageResult;
import com.jb.util.PageUtilEasyui;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("material")
public interface MaterialApiService {


    /**
     * 我的材料单查询
     */
    @RequestMapping("queryCustomMadePr")
    PageResult queryCustomMadePr(PageUtilEasyui<CustomMadePr> pageUtilEasyui);

    /**
     *材料单查询
     * @param id
     * @return
     */
    @RequestMapping("queryCxyCustomMadePr")
    List<CustomMadePr> queryCxyCustomMadePr(String id);


    /**
     * 删除
     * @param id
     */
    @RequestMapping("deleteCxyCustomMadePr")
    void deleteCxyCustomMadePr(String id);

    /**
     * 修改
     * @param customMadePr
     */
    @RequestMapping("updateCxyCustomMadePr")
    void updateCxyCustomMadePr(CustomMadePr customMadePr);


    /**
     * 修改我的材料单内容(材料单名称)
     * @param
     * @return
     */
    @RequestMapping("updateBillOfMaterials")
    void updateBillOfMaterials(BillOfMaterials billOfMaterials);

    @RequestMapping("queryTChannelList")
    List<TChannel> queryTChannelList();

    @RequestMapping("updateCount")
    void updateCount(TMaterial tMaterial);

   @RequestMapping("updateBrand")
    void updateBrand(TMaterial tMaterial);

    @RequestMapping("updateUnitprice")
    void updateUnitprice(TMaterial tMaterial);

    @RequestMapping("delServiceQuotation")
    void delServiceQuotation(String id);
}
