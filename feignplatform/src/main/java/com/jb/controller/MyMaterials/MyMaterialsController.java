package com.jb.controller.MyMaterials;

import com.jb.model.CustomMadePr;
import com.jb.model.TChannel;
import com.jb.model.TMaterial;
import com.jb.model.TMymaterials;
import com.jb.service.MyMaterialsApiService;
import com.jb.util.PageResult;
import com.jb.util.PageUtilEasyui;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MyMaterialsController {

    @Autowired
    private MyMaterialsApiService myMaterialsService;

    /**
     * 查询我的材料
     * @return
     */
    @RequestMapping("queryMyMaterials")
    @ResponseBody
    public List<TMymaterials> queryMyMaterials(){
        return myMaterialsService.queryMyMaterials();
    }

    /**
     * 分页查询我的材料
     * @param pageUtilEasyui
     * @param tMymaterials
     * @return
     */
    @GetMapping("queryMyMaterialsPage")
    @ResponseBody
    public PageResult queryMyMaterialsPage(Integer page,Integer rows,CustomMadePr customMadePr){
        customMadePr.setPage(page);
        customMadePr.setRows(rows);
        return myMaterialsService.queryMyMaterialsPage(customMadePr);
    }

    /**
     * 根据ID回显获取数据
     * @param id
     * @return
     */
    @RequestMapping("queryTMymaterialsById")
    @ResponseBody
    public CustomMadePr queryTMymaterialsById(CustomMadePr customMadePr){
        return myMaterialsService.queryTMymaterialsById(customMadePr);
    }

    /**
     * 新增或修改
     * @return
     */
    @RequestMapping("saveTMymaterials")
    @ResponseBody
    public Boolean saveTMymaterials(CustomMadePr customMadePr){
        try {
            if(customMadePr.getId() != null && customMadePr.getId() != ""){
                myMaterialsService.updateTMymaterialsById(customMadePr);
            }else{
                myMaterialsService.saveTMymaterials(customMadePr);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 根据ID删除
     * @return
     */
    @RequestMapping("deleteTMymaterialsById")
    @ResponseBody
    public Boolean deleteTMymaterialsById(String ids){
        try {
            myMaterialsService.deleteTMymaterialsById(ids);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 查询渠道下拉框展示
     * @return
     */
    @RequestMapping("queryTchannel")
    @ResponseBody
    public List<TChannel> queryTChannel(){
        return myMaterialsService.queryTChannel();
    }

    /**
     * 查看材料单
     * @return
     */
    @RequestMapping("queryTMaterial")
    @ResponseBody
    public List<CustomMadePr> queryTMaterial(String id){
        return myMaterialsService.queryTMaterial(id);
    }

}
