package com.jb.controller.seller;

import com.jb.model.BillOfMaterials;
import com.jb.model.CustomMadePr;
import com.jb.model.TChannel;
import com.jb.model.TMaterial;
import com.jb.service.MaterialApiService;
import com.jb.util.PageResult;
import com.jb.util.PageUtilEasyui;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MaterialController {

    @Autowired
    private MaterialApiService materialApiService;


    /**
     * 我的材料单查询
     * BillOfMaterials 我的材料单表
     * material  材料
     */
    @RequestMapping("queryCustomMadePr")
    @ResponseBody
    public PageResult queryCustomMadePr(PageUtilEasyui<CustomMadePr> pageUtilEasyui, CustomMadePr customMadePr){
        pageUtilEasyui.setT(customMadePr);
        return materialApiService.queryCustomMadePr(pageUtilEasyui);
    }


    /**
     *查看材料单查询
     * @param id
     * @return
     */
    @RequestMapping("queryCxyCustomMadePr")
    @ResponseBody
    public List<CustomMadePr>queryCxyCustomMadePr(String id){
        return materialApiService.queryCxyCustomMadePr(id);
    }


    /**
     * 删除菜单表
     * @param id
     */
    @RequestMapping("deleteCxyCustomMadePr")
    @ResponseBody
    public Boolean deleteCxyCustomMadePr(String id) {
        try {
            materialApiService.deleteCxyCustomMadePr(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    /**
     * 删除服务表
     * ServiceQuotation
     * @param id
     */
    @RequestMapping("delServiceQuotation")
    @ResponseBody
    public Boolean delServiceQuotation(String id) {
        try {
            materialApiService.delServiceQuotation(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 修改查看材料单内容
     * @param
     * @return
     */
    @RequestMapping("updateCxyCustomMadePr")
    @ResponseBody
    public Boolean updateCxyMaterial(CustomMadePr customMadePr){
        try {
                materialApiService.updateCxyCustomMadePr(customMadePr);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 修改我的材料单内容(材料单名称)
     * @param
     * @return
     */
    @RequestMapping("updateBillOfMaterials")
    @ResponseBody
    public Boolean updateBillOfMaterials(BillOfMaterials billOfMaterials){
        try {
            materialApiService.updateBillOfMaterials(billOfMaterials);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }



    //查询渠道下拉表
    @RequestMapping("queryTChannelList")
    @ResponseBody
    public List<TChannel> queryTChannelList(){
        return materialApiService.queryTChannelList();
    }



    /**
     * 修改我的材料单内容(数量)
     * @param
     * @return
     */
    @RequestMapping("updateCount")
    @ResponseBody
    public Boolean updateCount(TMaterial tMaterial){
        try {
            materialApiService.updateCount(tMaterial);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }



/**
 * 修改我的材料单内容(品牌)
 * @param
 * @return
 */
    @RequestMapping("updateBrand")
    @ResponseBody
    public Boolean updateBrand(TMaterial tMaterial){
        try {
            materialApiService.updateBrand(tMaterial);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }



    /**
     * 修改我的材料单内容(价格)
     * @param
     * @return
     */
    @RequestMapping("updateUnitprice")
    @ResponseBody
    public Boolean updateUnitprice(TMaterial tMaterial) {
        try {
            materialApiService.updateUnitprice(tMaterial);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
