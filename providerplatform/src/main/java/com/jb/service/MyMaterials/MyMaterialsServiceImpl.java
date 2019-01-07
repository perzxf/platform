package com.jb.service.MyMaterials;

import com.jb.mapper.seller.MyMaterialsMapper;
import com.jb.model.CustomMadePr;
import com.jb.model.TChannel;
import com.jb.model.TMymaterials;
import com.jb.util.PageResult;
import com.jb.util.PageUtil;
import com.jb.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class MyMaterialsServiceImpl implements MyMaterialsService{

    @Autowired
    private MyMaterialsMapper myMaterialsMapper;

    @Override
    public List<TMymaterials> queryMyMaterials() {
        return myMaterialsMapper.queryMyMaterials();
    }

    @Override
    public PageResult queryMyMaterialsPage(CustomMadePr customMadePr) {
        //总返回体
        PageResult pageResult = new PageResult();
        //查询参数
        HashMap<String, Object> params = new HashMap<>();
        params.put("customMadePr",customMadePr);
        //查询count
        int count = myMaterialsMapper.queryMyMaterialsCount(params);
        //把查询出来的count放到总返回当中
        pageResult.setTotal(count);
        //构建分页工具类
        PageUtil<CustomMadePr> pageUtil = new PageUtil<>(count, customMadePr.getPage(), customMadePr.getRows());
        params.put("startIndex",pageUtil.getStartIndex());//当前页
        params.put("rows",pageUtil.getEndIndex());//每页几条
        //分页查询列表queryUserByAccount
        List<CustomMadePr> list = myMaterialsMapper.queryMyMaterialsPage(params);
        //将查询出来的list放到总返回体重
        pageResult.setRows(list);
        return pageResult;
    }

    @Override
    public CustomMadePr queryTMymaterialsById(CustomMadePr customMadePr) {
        return myMaterialsMapper.queryTMymaterialsById(customMadePr);
    }

    @Override
    public void saveTMymaterials(CustomMadePr customMadePr) {
        customMadePr.setId(StringUtil.getUUId());
        myMaterialsMapper.saveTMymaterials(customMadePr);
    }

    @Override
    public void updateTMymaterialsById(CustomMadePr customMadePr) {
        System.out.println(customMadePr.getCount());
        myMaterialsMapper.updateTMymaterialsById(customMadePr);
    }

    @Override
    public void deleteTMymaterialsById(String ids) {
        myMaterialsMapper.deleteTMymaterialsById(ids);
    }

    @Override
    public List<TChannel> queryTChannel() {
        return myMaterialsMapper.queryTChannel();
    }

    @Override
    public List<CustomMadePr> queryTMaterial(String id) {
        return myMaterialsMapper.queryTMaterial(id);
    }

}
