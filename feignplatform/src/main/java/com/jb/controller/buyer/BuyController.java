package com.jb.controller.buyer;


import com.alibaba.fastjson.JSON;
import com.jb.entity.CustomBean;
import com.jb.model.*;
import com.jb.repositroy.PlatformRepostory;
import com.jb.service.BuyServiceApi;
import com.jb.util.JsonUtils;
import com.jb.util.PageResult;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Controller
@Component
public class BuyController {
    @Autowired
    private BuyServiceApi buyServiceApi;

    @Autowired
    protected RedisTemplate<String, String> redisTemplate;

    /**
     * 延期
     * @param time
     * @return
     */
    @RequestMapping("postpone")
    @ResponseBody
    public Boolean postpone(Postpone postpone){
        try {
            buyServiceApi.updatepostpone(postpone);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }



    /**
     * 固定cron配置定时任务
     */
    @Scheduled(cron = "0/10 * * * * ?")   //每10秒触发一次
    //@Scheduled(cron = "0 0 8 * * ? ")   //每天8点中触发一次
    public void doTask(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd");
        //System.out.println("当前时间为:"+sdf.format(new Date()));
        List<CustomMadePr> customMadePr= buyServiceApi.queryCustomBean();
        Date dateNow = new Date();
        String format = sdfTime.format(dateNow);
       // System.out.println("当前时间"+format);
        for(CustomMadePr custom:customMadePr){
            String time = custom.getTime();
          //  System.out.println("数据库时间"+time);
        }
    }

    /**
     * 定制询价单条件查询
     * @param page
     * @param rows
     * @param pageBean
     * @return
     */
    @RequestMapping("queryItem")
    @ResponseBody
    public PageResult queryItem(Integer page, Integer rows, CustomMadePr pageBean){
        pageBean.setPage(page);
        pageBean.setRows(rows);
        return buyServiceApi.queryItem(pageBean);
    }

    /**
     * 查询发布定制需求--发布范围
     * @return
     */
    @GetMapping("queryXzlmTrenchBean")
    @ResponseBody
    public List<TChannel> queryTChannelEg(){
        return buyServiceApi.queryTChannelEg();
    }

    /**
     * 查询发布定制需求--所属类目
     * @param pid
     * @return
     */
    @GetMapping("queryXzlmTypeBean")
    @ResponseBody
    public List<CustomizedProductCategories> queryCategories(String pid){
        return buyServiceApi.queryCategories(pid);
    }

    /**
     * 缓存数据redis
     * @param tZong
     * @return
     */
    @PostMapping("addXzlmCustom")
    @ResponseBody
    public String addXzlmCustom(TZong tZong){
        //缓存key
        String cacheKey = "addXzlmCustom";
        String jsonString = JSON.toJSONString(tZong);
        //缓存数据到redis中
        redisTemplate.opsForValue().set(cacheKey, jsonString);
        //设置权限缓存的过期时间 30分钟
        redisTemplate.expire(cacheKey,24, TimeUnit.HOURS);
        return "1";
    }
    /**
     * 缓存数据redis
     * @param buyerSproductUpdate
     * @return
     */
    @PostMapping("addCustom")
    @ResponseBody
    public String addCustom(BuyerSproductUpdate buyerSproductUpdate){
        //缓存key
        String cacheKey = "addCustom";
        String jsonString = JSON.toJSONString(buyerSproductUpdate);
        //缓存数据到redis中
        redisTemplate.opsForValue().set(cacheKey, jsonString);
        //设置权限缓存的过期时间 30分钟
        redisTemplate.expire(cacheKey,24, TimeUnit.HOURS);
        return "1";
    }

    /**
     * 缓存数据redis
     * @param buyersFigureUpdate
     * @return
     */
    @PostMapping("savePollingFigureredis")
    @ResponseBody
    public String savePollingFigureredis(BuyersFigureUpdate buyersFigureUpdate){
        //缓存key
        String cacheKey = "savePollingFigureredis";
        String jsonString = JSON.toJSONString(buyersFigureUpdate);
        //缓存数据到redis中
        redisTemplate.opsForValue().set(cacheKey, jsonString);
        //设置权限缓存的过期时间 30分钟
        redisTemplate.expire(cacheKey,24, TimeUnit.HOURS);
        return "1";
    }

    /**
     * 缓存数据redis
     * @param xunJiaDan
     * @return
     */
    @PostMapping("saveinquiry")
    @ResponseBody
    public String saveinquiry(XunJiaDan xunJiaDan){
        //缓存key
        String cacheKey = "xunJiaDan";
        String jsonString = JSON.toJSONString(xunJiaDan);
        //缓存数据到redis中
        redisTemplate.opsForValue().set(cacheKey, jsonString);
        //设置权限缓存的过期时间 30分钟
        redisTemplate.expire(cacheKey,24, TimeUnit.HOURS);
        return "1";
    }

    /**
     * 取redis数据走rabbitmq新增
     * @return
     */
    @PostMapping("savePollingFigure")
    @ResponseBody
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
        buyServiceApi.savePollingFigure(buyShop);
        return "1";
    }

    /**
     * 发布询价单
     * @return
     */
    @PostMapping("insertinquiry")
    @ResponseBody
    public String insertinquiry (){
        String cacheKey = "xunJiaDan";
        String cacheValue =redisTemplate.opsForValue().get(cacheKey);
        XunJiaDan xunJiaDan= JsonUtils.jsonToPojo(cacheValue,XunJiaDan.class);
        buyServiceApi.insertinquiry(xunJiaDan);
        return "1";
    }

    @Autowired
    private PlatformRepostory platformRepostory;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @GetMapping("saveIndex")
    public void insertIndex(){
        List<CustomMadePr> customMadePr= buyServiceApi.queryCustomBean();
        CustomBean customBean = new CustomBean();
        for(CustomMadePr custom:customMadePr){
            BeanUtils.copyProperties(custom,customBean);
            platformRepostory.save(customBean);
        }
    }

    @GetMapping("queryItemCustomBean")
    @ResponseBody
    public PageResult queryPrizeBean(Integer page, Integer rows, CustomBean customBean){
        PageResult pageResult = new PageResult();
        List<CustomBean> customList = new ArrayList<>();
        //获取elasticsearch客户端
        Client client = elasticsearchTemplate.getClient();
        //创建查询对象
        SearchRequestBuilder searchRequestBuilder = client
        //查询具体的索引 参数为索引名称
                .prepareSearch("platform")
        //查询具体的类型 参数为类型名称 可以传多个
                .setTypes("elplatform").setFrom(page).setSize(rows);
        //设置查询条件  matchQuery 条件查询 name值为字段名 text 要查询的内容
        if(!"".equals(customBean.getBomName()) && customBean.getBomName()!=null){
            searchRequestBuilder.setQuery(QueryBuilders.matchQuery("bomName",customBean.getBomName()));
        }
        //构建高亮展示对象
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.field("bomName");
        searchRequestBuilder.highlighter(highlightBuilder);
        //获取到查询结果 执行查询
        SearchResponse searchResponse = searchRequestBuilder.get();
        //获取到结果集中的数据
        SearchHits hits = searchResponse.getHits();
        //总条数
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
            String typeId = (String) source.get("typeId");
            String ttName = (String) source.get("ttName");
            String tcName = (String) source.get("tcName");
            Integer orderSize = (Integer) source.get("orderSize");
            String materialId = (String) source.get("materialId");
            String serviceId = (String) source.get("serviceId");
            String annexId = (String) source.get("annexId");
            String startime = (String)source.get("startime");
            String time = (String)source.get("time");
            String billTime = (String)source.get("billTime");
            //获取到所有高亮的字段
            Map<String, HighlightField> highlightFields = next.getHighlightFields();
            //获取高亮内容
            HighlightField bomName1 = highlightFields.get("bomName");
            CustomBean customMadePrs = new CustomBean();
            customMadePrs.setId(id);
            customMadePrs.setBomName(bomName);
            customMadePrs.setTypeId(typeId);
            customMadePrs.setTtName(ttName);
            customMadePrs.setTcName(tcName);
            customMadePrs.setOrderSize(orderSize);
            customMadePrs.setMaterialId(materialId);
            customMadePrs.setServiceId(serviceId);
            customMadePrs.setAnnexId(annexId);
            customMadePrs.setStartime(startime);
            customMadePrs.setTime(time);
            customMadePrs.setBillTime(billTime);
            customList.add(customMadePrs);
        }
        pageResult.setRows(customList);
        return pageResult;
    }


    /**
     * 删除已失效订单
     * @param id
     * @return
     */
    @RequestMapping("deleteorder")
    @ResponseBody
    public Boolean deleteorder(Postpone postpone){
        try {
            buyServiceApi.deleteorder(postpone);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * 重新发布
     * @return
     */
    @RequestMapping("updatestarStatuss")
    @ResponseBody
    public Boolean updatestarStatuss(Postpone postpone){
        try {
            buyServiceApi.updatestarStatuss(postpone);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


}
