package com.jb.controller.seller;


import com.alibaba.fastjson.JSON;
import com.jb.model.CustomMadePr;
import com.jb.model.TAnnex;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SellController {
    //注入rabbitMq工具类
    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * 放弃报价
     * @param id
     * @return
     */
    @PostMapping("waiveOffer")
    public String waiveOffer(String id){
        amqpTemplate.convertAndSend("updateWaiveOffer", id);
        return "1";
    }

    /**
     * 上传
     * 定制比价管理（服务商）
     * @param tAnnex
     * @return
     */
    @PostMapping("toAddSave")
    public String addFolder(TAnnex tAnnex) {
        amqpTemplate.convertAndSend("myqueue666",JSON.toJSONString(tAnnex));
        return "1";
    }

    /**
     * 删除
     *
     * @param id
     */
    @RequestMapping("deleteSupp")
    @ResponseBody
    public String deleteSupp(String id) {
        amqpTemplate.convertAndSend("deleSuppiy",id);
        return "1";
    }

    @RequestMapping("updateCustomMadePr")
    public void updateCustomMadePr(CustomMadePr customMadePr){
        amqpTemplate.convertAndSend("zzzz",JSON.toJSONString(customMadePr));
    }
}
