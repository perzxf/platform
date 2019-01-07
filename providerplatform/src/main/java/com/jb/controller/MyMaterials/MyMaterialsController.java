package com.jb.controller.MyMaterials;

import com.jb.model.CustomMadePr;
import com.jb.model.TChannel;
import com.jb.model.TMymaterials;
import com.jb.service.MyMaterials.MyMaterialsService;
import com.jb.service.MyMaterialsApiService;
import com.jb.util.JsonUtils;
import com.jb.util.PageResult;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController  //JingBeiController  相当于JingBeiApiServiceImpl实现类
public class MyMaterialsController implements MyMaterialsApiService {

    @Autowired
    private MyMaterialsService myMaterialsService;

    @Override
    public List<TMymaterials> queryMyMaterials() {
        return myMaterialsService.queryMyMaterials();
    }

    @Override
    public PageResult queryMyMaterialsPage(@RequestBody CustomMadePr customMadePr) {
        return myMaterialsService.queryMyMaterialsPage(customMadePr);
    }

    @Override
    public CustomMadePr queryTMymaterialsById(@RequestBody CustomMadePr customMadePr) {
        return myMaterialsService.queryTMymaterialsById(customMadePr);
    }

    @Override
    public void saveTMymaterials(@RequestBody CustomMadePr customMadePr) {
        myMaterialsService.saveTMymaterials(customMadePr);
    }

    @Override
    public void updateTMymaterialsById(@RequestBody CustomMadePr customMadePr) {
        myMaterialsService.updateTMymaterialsById(customMadePr);
    }

    @Override
    public void deleteTMymaterialsById(@RequestBody String ids) {
        myMaterialsService.deleteTMymaterialsById(ids);
    }

    @Override
    public List<TChannel> queryTChannel() {
        return myMaterialsService.queryTChannel();
    }

    @Override
    public List<CustomMadePr> queryTMaterial(@RequestBody String id) {
        return myMaterialsService.queryTMaterial(id);
    }

    @RabbitListener(queues = "zzzz")
    public void listenerBookMessage(String message){
        CustomMadePr customMadePr = JsonUtils.jsonToPojo(message, CustomMadePr.class);
        myMaterialsService.updateTMymaterialsById(customMadePr);
    }
}
