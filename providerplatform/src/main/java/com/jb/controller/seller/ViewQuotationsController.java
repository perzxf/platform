package com.jb.controller.seller;

import com.jb.model.TMaterial;
import com.jb.model.TServiceQuotation;

import com.jb.service.MaterialService;
import com.jb.service.seller.IViewQuotationsService;
import com.jb.util.JsonUtils;
import com.jb.util.PageResult;
import com.jb.util.PageUtilEasyui;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ViewQuotationsController implements MaterialService {

    @Autowired
    private IViewQuotationsService iviewQuotationsService;


    @Override
    public PageResult queryMaterial(@RequestBody PageUtilEasyui<TMaterial> page) {

        return iviewQuotationsService.queryMaterial(page);
    }

    @Override
    public List<TServiceQuotation> queryTServiceQuotation(@RequestBody TServiceQuotation tServiceQuotation) {
        return iviewQuotationsService.queryTServiceQuotation(tServiceQuotation);
    }

    @Override
    public void updateMaterialPriceAndbander(@RequestBody TMaterial material) {
        iviewQuotationsService.updateMaterialPrice(material);
    }

    @Override
    public void updateMaterialBrand(@RequestBody TMaterial material) {
        iviewQuotationsService.updateMaterialBrand(material);
    }

    @Override
    public void updateServicePrice(TServiceQuotation tServiceQuotation) {
        iviewQuotationsService.updateServicePrice(tServiceQuotation);
    }

    @RabbitListener(queues = "gzxUpdateTMaterial")
    public void listenerBookMessage(String message){
        List<TMaterial> tMaterial = JsonUtils.jsonToList(message,TMaterial.class);     //JsonUtils.jsonToPojo(message, TMaterial.class);
        iviewQuotationsService.updateTMaterial(tMaterial);
    }
    @RabbitListener(queues = "gzxupdateService")
    public void gzxupdateService(String message){
        List<TServiceQuotation> tServiceQuotation = JsonUtils.jsonToList(message,TServiceQuotation.class);     //JsonUtils.jsonToPojo(message, TMaterial.class);
        iviewQuotationsService.updateService(tServiceQuotation);
    }

    @RabbitListener(queues = "gzxupdateCustommadepr")
    public void gzxupdateCustommadepr(String message){
        TMaterial tMaterial = JsonUtils.jsonToPojo(message,TMaterial.class);     //JsonUtils.jsonToPojo(message, TMaterial.class);
        iviewQuotationsService.updateCustommadepr(tMaterial);
    }


}
