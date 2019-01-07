package com.jb.controller.seller;

import com.jb.model.BillOfMaterials;
import com.jb.model.CustomMadePr;
import com.jb.model.TChannel;
import com.jb.model.TMaterial;
import com.jb.service.MaterialApiService;
import com.jb.service.seller.MaterialService;
import com.jb.util.PageResult;
import com.jb.util.PageUtilEasyui;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController  //JingBeiController  相当于JingBeiApiServiceImpl实现类
public class MaterialController implements MaterialApiService {


    @Autowired
    private MaterialService materialService;


    /**
     * 我的材料单查询
     */
    @Override
    public PageResult queryCustomMadePr(@RequestBody PageUtilEasyui<CustomMadePr> pageUtilEasyui) {
        return materialService.queryCustomMadePr(pageUtilEasyui);
    }

    /**
     * 查看材料单
     * @param id
     * @return
     */
    @Override
    public List<CustomMadePr> queryCxyCustomMadePr(@RequestBody String id) {
        return materialService.queryCxyCustomMadePr(id);
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void deleteCxyCustomMadePr(@RequestBody String id) {
        materialService.deleteCxyCustomMadePr(id);
    }


    /**
     * 修改
     * @param customMadePr
     */
    @Override
    public void updateCxyCustomMadePr(@RequestBody CustomMadePr customMadePr) {
        materialService.updateCxyCustomMadePr(customMadePr);
    }


    /**
     * 修改我的材料单内容(材料单名称)
     * @param
     * @return
     */
    @Override
    public void updateBillOfMaterials(@RequestBody BillOfMaterials billOfMaterials) {
        materialService.updateBillOfMaterials(billOfMaterials);
    }

    @Override
    public List<TChannel> queryTChannelList() {
        return materialService.queryTChannelList();
    }

    @Override
    public void updateCount(@RequestBody TMaterial tMaterial) {
        materialService.updateCount(tMaterial);
    }

    @Override
    public void updateBrand(@RequestBody TMaterial tMaterial) {
        materialService.updateBrand(tMaterial);
    }

    @Override
    public void updateUnitprice(@RequestBody TMaterial tMaterial) {
        materialService.updateUnitprice(tMaterial);
    }

    @Override
    public void delServiceQuotation(@RequestBody String id) {
        materialService.delServiceQuotation(id);

    }


}

