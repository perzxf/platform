package com.jb.service.seller;

import com.jb.mapper.seller.SellMapper;
import com.jb.model.*;
import com.jb.util.PageResult;
import com.jb.util.PageUtil;
import com.jb.util.PageUtilEasyui;
import com.jb.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class SellServiceImpl implements SellService {
    @Autowired
    private SellMapper sellMapper;

    @Override
    public List<TChannel> queryChannel() {
        return sellMapper.queryChannel();
    }

    @Override
    public List<TType> queryType() {
        return sellMapper.queryType();
    }

    @Override
    public PageResult queryPbpaPageList(PageUtilEasyui<CustomMadePr> pageUtilEasyui) {
        //总返回体
        PageResult pageResult = new PageResult();
        //查询参数
        HashMap<String, Object> params = new HashMap<>();
        params.put("customMadePr",pageUtilEasyui.getT());
        //查询count
        int count = sellMapper.queryCustomMadePrPageCount(params);
        //把查询出来的count放到总返回当中
        pageResult.setTotal(count);
        //构建分页工具类
        params.put("startIndex",pageUtilEasyui.getStartIndex());//当前页
        params.put("rows",pageUtilEasyui.getRows());//每页几条
        //分页查询列表
        List<CustomMadePr> list = sellMapper.queryCustomMadePrPageList(params);
        //将查询出来的list放到总返回体重
        pageResult.setRows(list);
        return pageResult;
    }

    @Override
    public InquiryList queryInquiryListt(InquiryList inquiryList) {
        return sellMapper.queryInquiryListt(inquiryList);
    }

    @Override
    public CustomizedProductInformation queryCustomizedProductInformation(CustomizedProductInformation cpi) {
        return sellMapper.queryCustomizedProductInformation(cpi);
    }

    @Override
    public void updateWaiveOfferById(String id) {
        sellMapper.updateWaiveOfferById(id);
    }

    @Override
    public PageResult queryListTAnnex(PageUtilEasyui<TAnnex> page) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("tAnnex",page.getT());
        Integer count=sellMapper.queryListTAnnexCount(map);
        PageUtil<TAnnex> pageUtil = new PageUtil<>(count, page.getPage(),page.getRows());
        map.put("startIndex",pageUtil.getStartIndex());
        map.put("rows",page.getRows());
        List<TAnnex> list=sellMapper.queryListTAnnex(map);
        PageResult re = new PageResult();
        re.setRows(list);
        re.setTotal(count);
        return re;
    }

    @Override
    public PageResult queryListTMaterial(TMaterial tMaterial) {
        //总返回体
        PageResult pageResult = new PageResult();
        //查询参数
        HashMap<String, Object> params = new HashMap<>();
        //查询count
        int count = sellMapper.queryListTMaterialCount(params);
        //把查询出来的count放到总返回当中
        pageResult.setTotal(count);
        //构建分页工具类
        params.put("startIndex", tMaterial.getPage());//当前页
        params.put("rows", tMaterial.getRows());//每页几条
        //分页查询列表
        List<TAnnex> list = sellMapper.queryListTMaterial(params);
        System.out.println(list);
        //将查询出来的list放到总返回体重
        pageResult.setRows(list);
        return pageResult;
    }

    @Override
    public void addFolder(TAnnex tAnnex) {
        TAnnex TAnnexList = new TAnnex();
        String number = tAnnex.getName();
        TAnnexList.setId(StringUtil.getUUId());
        TAnnexList.setName(tAnnex.getName());
        TAnnexList.setUrl(tAnnex.getUrl());
        TAnnexList.setPid(tAnnex.getPid());
        //System.out.println(TAnnexList);
        sellMapper.addFolder(TAnnexList);
    }

    @Override
    public void deleteSuppiy(TAnnex tAnnex) {
        sellMapper.deleteSuppiy(tAnnex.getId());
    }

    @Override
    public PageResult queryListscheme(TAnnex tAnnex) {
        //总返回体
        PageResult pageResult = new PageResult();
        //查询参数
        HashMap<String, Object> params = new HashMap<>();
        //查询count
        int count = sellMapper.queryListschemeCount(params);
        //把查询出来的count放到总返回当中
        pageResult.setTotal(count);
        //构建分页工具类
        params.put("startIndex", tAnnex.getPage());//当前页
        params.put("rows", tAnnex.getRows());//每页几条
        //分页查询列表
        List<TAnnex> list = sellMapper.queryListscheme(params);
        System.out.println(list);
        //将查询出来的list放到总返回体重
        pageResult.setRows(list);
        return pageResult;
    }

    @Override
    public List<CustomMadePr> queryCustomMadePrList() {
        return sellMapper.queryCustomMadePrList();
    }
}
