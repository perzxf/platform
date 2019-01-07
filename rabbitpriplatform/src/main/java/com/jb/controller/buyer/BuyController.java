package com.jb.controller.buyer;


import com.alibaba.fastjson.JSON;
import com.jb.model.BuyShop;
import com.jb.model.BuyerSproductUpdate;
import com.jb.model.BuyersFigureUpdate;
import com.jb.model.TZong;
import com.jb.util.JsonUtils;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BuyController {
    //注入rabbitMq工具类
    @Autowired
    private AmqpTemplate amqpTemplate;

    @Autowired
    protected RedisTemplate<String, String> redisTemplate;

    /**
     * 取消询价单
     * @param id
     * @return
     */
    @PostMapping("updatestarStatus")
    public String updatestarStatus(String id){
        amqpTemplate.convertAndSend("updateSpringqueue", id);
        return "1";
    }

    /**
     * 取redis数据走rabbitmq新增
     * @return
     */
    @PostMapping("savePollingFigure")
    public String savePollingFigure(){
        String cacheKey1 = "addXzlmCustom";
        String cacheKey2 = "addCustom";
        String cacheKey3 = "savePollingFigureredis";
        String cacheValue1 =redisTemplate.opsForValue().get(cacheKey1);
        String cacheValue2 =redisTemplate.opsForValue().get(cacheKey2);
        String cacheValue3 =redisTemplate.opsForValue().get(cacheKey3);
        TZong test1= JsonUtils.jsonToPojo(cacheValue1,TZong.class);
        BuyerSproductUpdate test2= JsonUtils.jsonToPojo(cacheValue2,BuyerSproductUpdate.class);
        BuyersFigureUpdate test3= JsonUtils.jsonToPojo(cacheValue3,BuyersFigureUpdate.class);
        BuyShop buyShop = new BuyShop();
        buyShop.setTZong(test1);
        buyShop.setBuyerSproductUpdate(test2);
        buyShop.setBuyersFigureUpdate(test3);
        amqpTemplate.convertAndSend("addSpringqueue", JSON.toJSONString(buyShop));
        return "1";
    }
}
