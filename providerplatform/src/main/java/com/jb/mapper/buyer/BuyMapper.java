package com.jb.mapper.buyer;

import com.jb.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface BuyMapper {

    int queryItemCount(HashMap<String, Object> params);

    List<CustomMadePr> queryItem(HashMap<String, Object> params);

    void updatestarStatusById(CustomMadePr pageBean);

    List<TChannel> queryTChannelEg();

    List<CustomizedProductCategories> queryCategories(String pid);

    void saveBillOfMaterials(BillOfMaterials billOfMaterials);

    void saveCustomMadePr(CustomMadePr customMadePr);

    void insertinquiry(InquiryList inquiryList);

    void saveCustomizedProductInformation(CustomizedProductInformation customizedProductInformation);

    void updatepostpone(Postpone postpone);

    List<CustomMadePr> queryCustomBean();

    void deleteorder(Postpone postpone);

    void updatestarStatuss(Postpone postpone);
}
