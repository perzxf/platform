package com.jb.service.buyer;

import com.jb.model.*;
import com.jb.util.PageResult;

import java.util.List;

public interface BuyService {
    PageResult queryItem(CustomMadePr pageBean);

    void updatestarStatusById(CustomMadePr pageBean);

    List<TChannel> queryTChannelEg();

    List<CustomizedProductCategories> queryCategories(String pid);

    void savePollingFigure(TZong tZong, BuyersFigureUpdate buyersFigureUpdate, BuyerSproductUpdate buyerSproductUpdate);

    void insertinquiry(XunJiaDan xunJiaDan);

    void updatepostpone(Postpone postpone);

    List<CustomMadePr> queryCustomBean();

    void deleteorder(Postpone postpone);

    void updatestarStatuss(Postpone postpone);
}
