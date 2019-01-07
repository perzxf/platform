package com.jb.service;

import com.jb.model.*;
import com.jb.util.PageResult;
import com.jb.util.PageUtilEasyui;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("sell")
public interface SellServiceApi {

    @RequestMapping("queryChannelInfo")
    List<TChannel> queryChannel();

    @RequestMapping("queryTypeInfo")
    List<TType> queryType();

    @RequestMapping("queryPbpaPageListInfo")
    PageResult queryPbpaPageList(PageUtilEasyui<CustomMadePr> pageUtilEasyui);

    @RequestMapping("queryInquiryListtInfo")
    InquiryList queryInquiryListt(InquiryList inquiryList);

    @RequestMapping("queryCustomizedProductInformationInfo")
    CustomizedProductInformation queryCustomizedProductInformation(CustomizedProductInformation cpi);

    @RequestMapping("queryListTAnnexInfo")
    PageResult queryListTAnnex(PageUtilEasyui<TAnnex> page);

    @RequestMapping("queryListschemeInfo")
    PageResult queryListscheme (TAnnex tAnnex);

    @RequestMapping("queryListTMaterialInfo")
    PageResult queryListTMaterial(TMaterial tMaterial);

    @RequestMapping("queryCustomMadePrListInfo")
    List<CustomMadePr> queryCustomMadePrList();

}
