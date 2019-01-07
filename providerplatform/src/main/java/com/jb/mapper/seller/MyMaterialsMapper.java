package com.jb.mapper.seller;

import com.jb.model.CustomMadePr;
import com.jb.model.TChannel;
import com.jb.model.TMymaterials;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface MyMaterialsMapper {
    List<TMymaterials> queryMyMaterials();

    int queryMyMaterialsCount(HashMap<String, Object> params);

    List<CustomMadePr> queryMyMaterialsPage(HashMap<String, Object> params);

    CustomMadePr queryTMymaterialsById(CustomMadePr customMadePr);

    void saveTMymaterials(CustomMadePr customMadePr);

    void updateTMymaterialsById(CustomMadePr customMadePr);

    void deleteTMymaterialsById(String ids);

    List<TChannel> queryTChannel();

    List<CustomMadePr> queryTMaterial(String id);
}
