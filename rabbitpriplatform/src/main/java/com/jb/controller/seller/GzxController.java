package com.jb.controller.seller;

import com.alibaba.fastjson.JSON;
import com.jb.model.TMaterial;
import com.jb.model.TServiceQuotation;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class GzxController {

    //注入rabbitMq工具类
    @Autowired
    private AmqpTemplate amqpTemplate;

    @PutMapping("updateMaterial")
    public void updateMaterial(@RequestBody List<TMaterial> tMaterial){
        amqpTemplate.convertAndSend("gzxUpdateTMaterial", JSON.toJSONString(tMaterial));
    }

    @PutMapping("updateService")
    public void updateService(@RequestBody List<TServiceQuotation> tServiceQuotation){
        amqpTemplate.convertAndSend("gzxupdateService", JSON.toJSONString(tServiceQuotation));
    }

    @PutMapping("updateCustommadepr")
    public void updateCustommadepr(@RequestBody TMaterial tMaterial){
        amqpTemplate.convertAndSend("gzxupdateCustommadepr", JSON.toJSONString(tMaterial));
    }

}
