package com.jb.controller.seller;

import com.jb.model.*;
import com.jb.repositroy.ProductRepostory;
import com.jb.service.SellServiceApi;
import com.jb.util.PageResult;
import com.jb.util.PageUtilEasyui;
import com.jb.util.UploadFileUtil;
import com.jb.utils.CustomMadePrs;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Component
public class SellController {
    @Autowired
    private SellServiceApi sellServiceApi;

    @Autowired
    protected RedisTemplate<String, String> redisTemplate;

   /* @Autowired
    private ProductRepostory productRepostory;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;*/

    /**
     * 固定cron配置定时任务
     */
    @Scheduled(cron = "0/20 * * * * ?")   //每20秒触发一次
    public void doTask(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //System.out.println("当前时间为:"+sdf.format(new Date()));
    }

    /**
     * 查询渠道
     */
    @RequestMapping("queryChannel")
    @ResponseBody
    public List<TChannel> queryChannel(){
        return sellServiceApi.queryChannel();
    }

    /**
     * 查询状态
     */
    @RequestMapping("queryType")
    @ResponseBody
    public List<TType> queryType(){
        return sellServiceApi.queryType();
    }

    /**
     * D-1定制比价管理（供应商）
     * @param pageUtilEasyui
     * @param customMadePr
     * @return
     */
    /*@RequestMapping("queryPbpaPageList")
    @ResponseBody
    public PageResult queryPbpaPageList(PageUtilEasyui<CustomMadePrs> pageUtilEasyui, CustomMadePrs customMadePr){
        PageResult pageResult = new PageResult();
        ArrayList<CustomMadePrs> list = new ArrayList<>();
        //获取elasticsearchTemplate客户端
        Client client = elasticsearchTemplate.getClient();
        //创建查询对象
        SearchRequestBuilder searchRequestBuilder = client
                //查询具体的索引 参数为索引名称
                .prepareSearch("custom")
                //查询具体的类型 参数为类型名称 可以传多个
                .setTypes("elcustom")
                .setFrom((pageUtilEasyui.getPage()-1)*(pageUtilEasyui.getRows()))
                .setSize(pageUtilEasyui.getRows());
        if(!"".equals(customMadePr.getBomName()) && customMadePr.getBomName()!=null){
            //设置查询条件 matchQuery 条件查询 name为字段名 type 为要查询的内容
            searchRequestBuilder.setQuery(QueryBuilders.matchQuery("bomName",customMadePr.getBomName()));
        }
        if(!"".equals(customMadePr.getTcId()) && customMadePr.getTcId()!=null){
            searchRequestBuilder.setQuery(QueryBuilders.matchQuery("tcId",customMadePr.getTcId()));
        }
        if(!"".equals(customMadePr.getTypeId()) && customMadePr.getTypeId()!=null){
            searchRequestBuilder.setQuery(QueryBuilders.matchQuery("typeId",customMadePr.getTypeId()));
        }
        //构建高亮展示字段
        //HighlightBuilder highlightBuilder = new HighlightBuilder();
        //highlightBuilder.field("bomName");
        //获取到查询结果 执行查询
        SearchResponse searchResponse = searchRequestBuilder.get();
        //获取到结果集中的数据
        SearchHits hits = searchResponse.getHits();
        //获取总条数
        int totalHits = (int) hits.totalHits;
        pageResult.setTotal(totalHits);
        //遍历结果集
        Iterator<SearchHit> iterator = hits.iterator();
        //判断集合中有无下一个元素 如果有 继续循环
        while (iterator.hasNext()){
            SearchHit next = iterator.next();
            Map<String, Object> source = next.getSource();
            String id = (String) source.get("id");
            String bomName = (String) source.get("bomName");
            //获取到所有高亮的字段
            Map<String, HighlightField> highlightFields = next.getHighlightFields();
            //获取高亮内容
            //Text[] bomNames = highlightFields.get("bomName").getFragments();
            String typeId = (String) source.get("typeId");
            String ttName = (String) source.get("ttName");
            String tcName = (String) source.get("tcName");
            String time = (String) source.get("time");
            Integer orderSize = (Integer) source.get("orderSize");
            String materialId = (String) source.get("materialId");
            String serviceId = (String) source.get("serviceId");
            String annexId = (String) source.get("annexId");
            CustomMadePrs customMadePrs = new CustomMadePrs();
            customMadePrs.setId(id);
            customMadePrs.setBomName(bomName);
            customMadePrs.setTypeId(typeId);
            customMadePrs.setTtName(ttName);
            customMadePrs.setTcName(tcName);
            customMadePrs.setTime(time);
            customMadePrs.setOrderSize(orderSize);
            customMadePrs.setMaterialId(materialId);
            customMadePrs.setServiceId(serviceId);
            customMadePrs.setAnnexId(annexId);
            list.add(customMadePrs);
        }
        pageResult.setRows(list);
        return pageResult;
    }*/

    @RequestMapping("queryPbpaPageList")
    @ResponseBody
    public PageResult queryPbpaPageList(PageUtilEasyui<CustomMadePr> pageUtilEasyui, CustomMadePr customMadePr){
        pageUtilEasyui.setT(customMadePr);
        return sellServiceApi.queryPbpaPageList(pageUtilEasyui);
    }

   /* @RequestMapping("saveElasticsearch")
    public void saveElasticsearch() {
        List<CustomMadePr> list = sellServiceApi.queryCustomMadePrList();
        CustomMadePrs customMadePrs = new CustomMadePrs();
        for (CustomMadePr customMadePr:list
        ) {
            BeanUtils.copyProperties(customMadePr,customMadePrs);
            System.out.println(customMadePrs.toString());
            productRepostory.save(customMadePrs);
        }
    }*/

    /**
     * 项目详情页询价单 D-1-1
     */
    @RequestMapping("queryInquiryListt")
    @ResponseBody
    public InquiryList queryInquiryListt(InquiryList inquiryList){
        return sellServiceApi.queryInquiryListt(inquiryList);
    }

    /**
     * 项目详情页定制产品信息 D-1-1
     */
    @RequestMapping("queryCustomizedProductInformation")
    @ResponseBody
    public CustomizedProductInformation queryCustomizedProductInformation(CustomizedProductInformation cpi){
        return sellServiceApi.queryCustomizedProductInformation(cpi);
    }

    /**
     * 图片上传
     * @param file
     * @param request
     * @return
     */
    @PostMapping("upload")
    @ResponseBody
    public Map<String, Object> uploadFile(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        Map<String, Object> fileUrl = UploadFileUtil.uploadFile(file, request);
        return fileUrl;
    }

    /**
     * 压缩下载
     * @param fileName
     * @param response
     */
    @RequestMapping("zipFile")
    public void  zipFile(String fileName, HttpServletResponse response) {
        UploadFileUtil.downloadFile(fileName, response);
    }

    @RequestMapping("downLoad")
    public void downLoad(String url, HttpServletResponse response) {
        UploadFileUtil.downloadFile(url, response);
    }

    /**
     * 查询 上传文件
     * @param page
     * @param tAnnex
     * @return
     */
    @RequestMapping("queryListTAnnex")
    @ResponseBody
    public PageResult queryListTAnnex(PageUtilEasyui<TAnnex> page, TAnnex tAnnex) {
        page.setT(tAnnex);
        return sellServiceApi.queryListTAnnex(page);
    }



    /**
     * 查询 方案详情
     *
     * @param page
     * @param rows
     * @param tAnnex
     * @return
     */
    @GetMapping(value="queryListscheme")
    @ResponseBody
    public PageResult queryListscheme(Integer page, Integer rows, TAnnex tAnnex) {
        tAnnex.setPage(page);
        tAnnex.setRows(rows);
        return sellServiceApi.queryListscheme(tAnnex);
    }

    /**
     * 查询 材料单
     * @param page
     * @param rows
     * @param tMaterial
     * @return
     */
    @RequestMapping("queryListTMaterial")
    @ResponseBody
    public PageResult queryListTMaterial(Integer page, Integer rows, TMaterial tMaterial) {
        tMaterial.setPage(page);
        tMaterial.setRows(rows);
        return sellServiceApi.queryListTMaterial(tMaterial);
    }


}
