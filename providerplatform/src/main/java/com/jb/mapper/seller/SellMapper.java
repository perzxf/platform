package com.jb.mapper.seller;

import com.jb.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface SellMapper {

    List<TChannel> queryChannel();

    List<TType> queryType();

    int queryCustomMadePrPageCount(HashMap<String, Object> params);

    List<CustomMadePr> queryCustomMadePrPageList(HashMap<String, Object> params);

    InquiryList queryInquiryListt(InquiryList inquiryList);

    CustomizedProductInformation queryCustomizedProductInformation(CustomizedProductInformation cpi);

    void updateWaiveOfferById(String id);

    int queryListTAnnexCount(HashMap<String, Object> params);

    List<TAnnex> queryListTAnnex(HashMap<String, Object> params);

    int queryListTMaterialCount(HashMap<String, Object> params);

    List<TAnnex> queryListTMaterial(HashMap<String, Object> params);

    void addFolder(TAnnex tAnnexList);

    void deleteSuppiy(String id);

    int queryListschemeCount(HashMap<String, Object> params);

    List<TAnnex> queryListscheme(HashMap<String, Object> params);

    List<CustomMadePr> queryCustomMadePrList();

}
