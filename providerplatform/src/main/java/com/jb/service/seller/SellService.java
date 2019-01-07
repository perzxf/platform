package com.jb.service.seller;

import com.jb.model.*;
import com.jb.util.PageResult;
import com.jb.util.PageUtilEasyui;

import java.util.List;

public interface SellService {
    List<TChannel> queryChannel();

    List<TType> queryType();

    PageResult queryPbpaPageList(PageUtilEasyui<CustomMadePr> pageUtilEasyui);

    InquiryList queryInquiryListt(InquiryList inquiryList);

    CustomizedProductInformation queryCustomizedProductInformation(CustomizedProductInformation cpi);

    void updateWaiveOfferById(String id);

    PageResult queryListTAnnex(PageUtilEasyui<TAnnex> page);
    /*PageResult queryListTAnnex(TAnnex tAnnex);*/

    PageResult queryListTMaterial(TMaterial tMaterial);

    void addFolder(TAnnex tAnnex);

    void deleteSuppiy(TAnnex tAnnex);

    PageResult queryListscheme(TAnnex tAnnex);

    List<CustomMadePr> queryCustomMadePrList();

}
