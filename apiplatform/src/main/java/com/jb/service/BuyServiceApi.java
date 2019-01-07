package com.jb.service;

import com.jb.model.*;
import com.jb.util.PageResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("buy")
public interface BuyServiceApi {

    @RequestMapping("queryItemInfo")
    PageResult queryItem(CustomMadePr pageBean);

    @RequestMapping("queryTChannelEgInfo")
    List<TChannel> queryTChannelEg();

    @RequestMapping("queryCategoriesInfo")
    List<CustomizedProductCategories> queryCategories(String pid);

    @RequestMapping("savePollingFigureInfo")
    void savePollingFigure(BuyShop buyShop);

    @RequestMapping("insertinquiryInfo")
    void insertinquiry(XunJiaDan xunJiaDan);

    @RequestMapping("postpone")
    void updatepostpone(Postpone postpone);

    @RequestMapping("queryCustomBeanInfo")
    List<CustomMadePr> queryCustomBean();


    @DeleteMapping("deleteorder")
    void deleteorder(Postpone postpone);

    @RequestMapping("updatestarStatuss")
    void updatestarStatuss(Postpone postpone);

}
