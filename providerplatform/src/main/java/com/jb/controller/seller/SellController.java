package com.jb.controller.seller;

import com.jb.model.*;
import com.jb.service.SellServiceApi;
import com.jb.service.seller.SellService;
import com.jb.util.JsonUtils;
import com.jb.util.PageResult;
import com.jb.util.PageUtilEasyui;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class SellController implements SellServiceApi {
    @Autowired
    private SellService sellService;

    @Override
    public List<TChannel> queryChannel() {
        return sellService.queryChannel();
    }

    @Override
    public List<TType> queryType() {
        return sellService.queryType();
    }

    @Override
    public PageResult queryPbpaPageList(@RequestBody PageUtilEasyui<CustomMadePr> pageUtilEasyui) {
        return sellService.queryPbpaPageList(pageUtilEasyui);
    }

    @Override
    public InquiryList queryInquiryListt(@RequestBody InquiryList inquiryList) {
        return sellService.queryInquiryListt(inquiryList);
    }

    @Override
    public CustomizedProductInformation queryCustomizedProductInformation(@RequestBody CustomizedProductInformation cpi) {
        return sellService.queryCustomizedProductInformation(cpi);
    }

    @Override
    public PageResult queryListTAnnex(@RequestBody PageUtilEasyui<TAnnex> page) {
        return sellService.queryListTAnnex(page);
    }

    @Override
    public PageResult queryListscheme(@RequestBody TAnnex tAnnex) {
        return sellService.queryListscheme(tAnnex);
    }


    @Override
    public PageResult queryListTMaterial(@RequestBody TMaterial tMaterial) {
        return sellService.queryListTMaterial(tMaterial);
    }

    @Override
    public List<CustomMadePr> queryCustomMadePrList() {
        return sellService.queryCustomMadePrList();
    }

    @RabbitListener(queues = "updateWaiveOffer")
    public void updateWaiveOfferById(String id){
        sellService.updateWaiveOfferById(id);
    }

    /**
     * 上传
     * 定制比价管理（服务商） 中的 修改方案
     * @param name
     */
    @RabbitListener(queues = "myqueue666")
    public void addFolder(String name) {
        TAnnex tAnnex = JsonUtils.jsonToPojo(name,TAnnex.class);
        sellService.addFolder(tAnnex);
    }
    /**
     * 定制比价管理（服务商） 删除
     *
     * @param id
     */
    @RabbitListener(queues = "deleSuppiy")
    public void deleteSuppiy(String id) {
        TAnnex tAnnex = new TAnnex();
        tAnnex.setId(id);
        sellService.deleteSuppiy(tAnnex);
    }
}
