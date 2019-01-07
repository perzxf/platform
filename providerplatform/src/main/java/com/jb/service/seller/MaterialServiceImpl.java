package com.jb.service.seller;

import com.jb.mapper.seller.MaterialMapper;
import com.jb.model.BillOfMaterials;
import com.jb.model.CustomMadePr;
import com.jb.model.TChannel;
import com.jb.model.TMaterial;
import com.jb.util.PageResult;
import com.jb.util.PageUtilEasyui;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    private MaterialMapper materialMapper;


    @Override
    public PageResult queryCustomMadePr(PageUtilEasyui<CustomMadePr> pageUtilEasyui) {
        //总返回体
        PageResult pageResult = new PageResult();
        //查询参数
        HashMap<String, Object> params = new HashMap<>();
        params.put("customMadePr",pageUtilEasyui.getT());
        //查询count
        int count = materialMapper.queryCustomMadePrCount(params);
        //把查询出来的count放到总返回当中
        pageResult.setTotal(count);
        //构建分页工具类
        params.put("startIndex",pageUtilEasyui.getStartIndex());//当前页
        params.put("rows",pageUtilEasyui.getRows());//每页几条
        //分页查询列表queryUserByAccount
        List<CustomMadePr> list = materialMapper.queryCustomMadePrPageList(params);
        //将查询出来的list放到总返回体重
        pageResult.setRows(list);
        return pageResult;
    }

    @Override
    public List<CustomMadePr> queryCxyCustomMadePr(String id) {
        return materialMapper.queryCxyCustomMadePr(id);
    }

    @Override
    public void deleteCxyCustomMadePr(String id) {
        materialMapper.deleteCxyCustomMadePr(id);
    }

    @Override
    public void updateCxyCustomMadePr(CustomMadePr customMadePr) {
        materialMapper.updateCxyCustomMadePr(customMadePr);
    }

    @Override
    public void updateBillOfMaterials(BillOfMaterials billOfMaterials) {
        materialMapper.updateBillOfMaterials(billOfMaterials);
    }

    @Override
    public List<TChannel> queryTChannelList() {
        return materialMapper.queryTChannelList();
    }

    @Override
    public void updateCount(TMaterial tMaterial) {
        materialMapper.updateCount(tMaterial);
    }

    @Override
    public void updateBrand(TMaterial tMaterial) {
        materialMapper.updateBrand(tMaterial);
    }

    @Override
    public void updateUnitprice(TMaterial tMaterial) {
        materialMapper.updateUnitprice(tMaterial);
    }

    @Override
    public void delServiceQuotation(String id) {
        materialMapper.delServiceQuotation(id);
    }


}
