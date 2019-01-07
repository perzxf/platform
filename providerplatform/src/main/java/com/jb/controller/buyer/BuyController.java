package com.jb.controller.buyer;

import com.alibaba.fastjson.JSON;
import com.jb.model.*;
import com.jb.service.BuyServiceApi;
import com.jb.service.buyer.BuyService;
import com.jb.util.JsonUtils;
import com.jb.util.PageResult;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class BuyController implements BuyServiceApi {
    @Autowired
    private BuyService buyService;

    @Override
    public PageResult queryItem(@RequestBody CustomMadePr pageBean) {
        return buyService.queryItem(pageBean);
    }

    @Override
    public List<TChannel> queryTChannelEg() {
        return buyService.queryTChannelEg();
    }

    @Override
    public List<CustomizedProductCategories> queryCategories(@RequestBody String pid) {
        return buyService.queryCategories(pid);
    }

    @Override
    public void savePollingFigure(@RequestBody BuyShop buyShop) {
        TZong tZong = buyShop.getTZong();
        BuyerSproductUpdate buyerSproductUpdate = buyShop.getBuyerSproductUpdate();
        BuyersFigureUpdate buyersFigureUpdate = buyShop.getBuyersFigureUpdate();
        buyService.savePollingFigure(tZong,buyersFigureUpdate,buyerSproductUpdate);
    }

    @Override
    public void insertinquiry(@RequestBody XunJiaDan xunJiaDan) {
        buyService.insertinquiry(xunJiaDan);
    }

    @Override
    public void updatepostpone(@RequestBody Postpone postpone) {
        buyService.updatepostpone(postpone);
    }

    @Override
    public List<CustomMadePr> queryCustomBean() {
        return buyService.queryCustomBean();
    }

    @RabbitListener(queues = "updateSpringqueue")
    public void updatestarStatusById(String id){
        CustomMadePr pageBean = new CustomMadePr();
        pageBean.setId(id);
        buyService.updatestarStatusById(pageBean);
    }

    @RabbitListener(queues = "addSpringqueue")
    public void savePollingFigure(String buyShop){
        BuyShop map = JSON.parseObject(buyShop,BuyShop.class);
        System.out.println(map.toString());
        /*TZong tZong = map.getTZong();
        BuyersFigureUpdate buyersFigureUpdate = map.getBuyersFigureUpdate();
        BuyerSproductUpdate buyerSproductUpdate = map.getBuyerSproductUpdate();
        buyService.savePollingFigure(tZong,buyersFigureUpdate,buyerSproductUpdate);*/
    }


    @Override
    public void deleteorder(@RequestBody Postpone postpone) {
        buyService.deleteorder(postpone);
    }

    @Override
    public void updatestarStatuss(@RequestBody Postpone postpone) {
        buyService.updatestarStatuss(postpone);
    }



}
