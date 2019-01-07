package com.jb.service;

import com.jb.model.CustomMadePr;
import com.jb.model.TChannel;
import com.jb.model.TMaterial;
import com.jb.model.TMymaterials;
import com.jb.util.PageResult;
import com.jb.util.PageUtilEasyui;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("MyMaterials")
public interface MyMaterialsApiService {

    @RequestMapping("queryMyMaterials")
    List<TMymaterials> queryMyMaterials();

    @RequestMapping("queryMyMaterialsPage")
    PageResult queryMyMaterialsPage(CustomMadePr customMadePr);

    @RequestMapping("queryTMymaterialsById")
    CustomMadePr queryTMymaterialsById(CustomMadePr customMadePr);

    @RequestMapping("saveTMymaterials")
    void saveTMymaterials(CustomMadePr customMadePr);

    @RequestMapping("updateTMymaterialsById")
    void updateTMymaterialsById(CustomMadePr customMadePr);

    @RequestMapping("deleteTMymaterialsById")
    void deleteTMymaterialsById(String ids);

    @RequestMapping("queryTChannel")
    List<TChannel> queryTChannel();

    @RequestMapping("queryTMaterial")
    List<CustomMadePr> queryTMaterial(String id);

}
