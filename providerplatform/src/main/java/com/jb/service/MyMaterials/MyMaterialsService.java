package com.jb.service.MyMaterials;

import com.jb.model.CustomMadePr;
import com.jb.model.TChannel;
import com.jb.model.TMymaterials;
import com.jb.util.PageResult;

import java.util.List;

public interface MyMaterialsService {
    List<TMymaterials> queryMyMaterials();

    PageResult queryMyMaterialsPage(CustomMadePr customMadePr);

    CustomMadePr queryTMymaterialsById(CustomMadePr customMadePr);

    void saveTMymaterials(CustomMadePr customMadePr);

    void updateTMymaterialsById(CustomMadePr customMadePr);

    void deleteTMymaterialsById(String ids);

    List<TChannel> queryTChannel();

    List<CustomMadePr> queryTMaterial(String id);

}
