package com.jb.service.buyer;

import com.alibaba.fastjson.JSON;
import com.jb.mapper.buyer.BuyMapper;
import com.jb.model.*;
import com.jb.util.DingDanHaoUtil;
import com.jb.util.PageResult;
import com.jb.util.PageUtil;
import com.jb.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class BuyServiceImpl implements BuyService {
    @Autowired
    private BuyMapper buyMapper;

    @Autowired
    protected RedisTemplate<String, String> redisTemplate;

    @Override
    public PageResult queryItem(CustomMadePr pageBean) {
        //总返回体
        PageResult pageResult = new PageResult();
        //查询参数
        HashMap<String, Object> params = new HashMap<>();
        params.put("pageBean",pageBean);
        //查询count
        int count = buyMapper.queryItemCount(params);
        //把查询出来的count放到总返回当中
        pageResult.setTotal(count);
        //构建分页工具类
        PageUtil <CustomMadePr> pageUtil = new PageUtil<>(count, pageBean.getPage(), pageBean.getRows());
        params.put("startIndex",pageUtil.getStartIndex());//当前页
        params.put("endIndex",pageUtil.getEndIndex());//每页几条
        //分页查询列表queryUserByAccount
        List<CustomMadePr> list = buyMapper.queryItem(params);
        //将查询出来的list放到总返回体重
        pageResult.setRows(list);
        return pageResult;
    }

    @Override
    public void updatestarStatusById(CustomMadePr pageBean) {
        buyMapper.updatestarStatusById(pageBean);
    }

    @Override
    public List<TChannel> queryTChannelEg() {
        return buyMapper.queryTChannelEg();
    }

    @Override
    public List<CustomizedProductCategories> queryCategories(String pid) {
        return buyMapper.queryCategories(pid);
    }

    @Override
    public void savePollingFigure(TZong tZong, BuyersFigureUpdate buyersFigureUpdate, BuyerSproductUpdate buyerSproductUpdate) {
        BillOfMaterials billOfMaterials = new BillOfMaterials();
        String uuId = DingDanHaoUtil.gen("CL", 001L);
        //String uuId = StringUtil.getUUId();
        billOfMaterials.setId(uuId);
        billOfMaterials.setChannelId(tZong.getTrench().toString());
        billOfMaterials.setName(buyerSproductUpdate.getName());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        billOfMaterials.setTime(simpleDateFormat.format(new Date()));
        buyMapper.saveBillOfMaterials(billOfMaterials);
        CustomMadePr customMadePr = new CustomMadePr();
        String customMadePrId = DingDanHaoUtil.gen("JB", 001L);
        //String customMadePrId = StringUtil.getUUId();
        customMadePr.setId(customMadePrId);
        customMadePr.setBillOfMaterialsId(uuId);
        customMadePr.setTypeId("1");
        customMadePr.setStartime(buyersFigureUpdate.getStartdate());
        customMadePr.setTime(buyersFigureUpdate.getAsofthedate());
        customMadePr.setOrderSize(buyerSproductUpdate.getCount());
        customMadePr.setMaterialId("4");
        customMadePr.setServiceId("1");
        String annexId = DingDanHaoUtil.gen("FJ", 001L);
        //String annexId = StringUtil.getUUId(); //附件ID
        customMadePr.setAnnexId(annexId);
        customMadePr.setRemarks(buyerSproductUpdate.getRemarks());
        customMadePr.setSupplyperiod("7");
        customMadePr.setEffectivetime(buyersFigureUpdate.getResultsreleasedate());
        customMadePr.setStatus(2);
        customMadePr.setItemstarstatus(1);

        //HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //request.getSession().setAttribute("customMadePrId",customMadePrId);

        //缓存key
        String cacheKey = "customMadePrId";
        //缓存数据到redis中
        redisTemplate.opsForValue().set(cacheKey, customMadePrId);
        //设置权限缓存的过期时间 30分钟
        redisTemplate.expire(cacheKey,24, TimeUnit.HOURS);

        buyMapper.saveCustomMadePr(customMadePr);
        CustomizedProductInformation customizedProductInformation = new CustomizedProductInformation();

        String customizedProductInformationId = DingDanHaoUtil.gen("DZ", 001L);

        customizedProductInformation.setId(customizedProductInformationId);
        customizedProductInformation.setName(buyerSproductUpdate.getType());
        customizedProductInformation.setImportMin(Integer.parseInt(buyerSproductUpdate.getMinentrance()));
        customizedProductInformation.setImportMax(Integer.parseInt(buyerSproductUpdate.getMaxentrance()));
        customizedProductInformation.setExitMin(Integer.parseInt(buyerSproductUpdate.getMinexport()));
        customizedProductInformation.setExitMax(Integer.parseInt(buyerSproductUpdate.getMaxexport()));
        customizedProductInformation.setRatedFlow(Integer.parseInt(buyerSproductUpdate.getFlow()));
        customizedProductInformation.setRegulatorKit(buyerSproductUpdate.getBrand());
        customizedProductInformation.setOuterBox(buyerSproductUpdate.getCarton());
        customizedProductInformation.setBoxMaterials(buyerSproductUpdate.getMaterial());
        customizedProductInformation.setRemarkSection(buyerSproductUpdate.getRemarks());
        customizedProductInformation.setPrId(customMadePrId);
        buyMapper.saveCustomizedProductInformation(customizedProductInformation);
    }

    @Override
    public void insertinquiry(XunJiaDan xunJiaDan) {
        InquiryList inquiryList = new InquiryList();
        String inquiryListId = DingDanHaoUtil.gen("XJ", 001L);
        inquiryList.setId(inquiryListId);
        inquiryList.setExpectedTotalPriceint(Integer.parseInt(xunJiaDan.getZongjia()));
        inquiryList.setPaymentNode(Integer.parseInt(xunJiaDan.getFukaunjiedian()));
        inquiryList.setPaymentRatio(xunJiaDan.getFukaunbili());
        inquiryList.setPaymentDays(Integer.parseInt(xunJiaDan.getFukaunday()));
        inquiryList.setInvoiceType(xunJiaDan.getFapiaotype());
        inquiryList.setTaxRate(xunJiaDan.getRate());
        inquiryList.setBillingType("按订单金额开票");
        inquiryList.setSettlement(xunJiaDan.getJiesuanshang());
        inquiryList.setModeOfDistribution("线上发货");
        inquiryList.setShippingAddress(xunJiaDan.getPeizhu());
        inquiryList.setPurchasingDepartment(xunJiaDan.getCaigoubumen());
        inquiryList.setDefaultFactory(xunJiaDan.getCaigoubumentwo());
        inquiryList.setDefaultWarehouse("南大库");
        inquiryList.setRemarkSection(xunJiaDan.getPeizhu());

        //HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //String customMadePrId =(String)request.getSession().getAttribute("customMadePrId");
        //缓存key
        String cacheKey = "customMadePrId";
        //取出redis的ID值
        String customMadePrId =redisTemplate.opsForValue().get(cacheKey);

        inquiryList.setPrId(customMadePrId);
        buyMapper.insertinquiry(inquiryList);
    }

    @Override
    public void updatepostpone(Postpone postpone) {
        buyMapper.updatepostpone(postpone);
    }

    @Override
    public List<CustomMadePr> queryCustomBean() {
        return buyMapper.queryCustomBean();
    }


    @Override
    public void deleteorder(Postpone postpone) {
        buyMapper.deleteorder(postpone);
    }

    @Override
    public void updatestarStatuss(Postpone postpone) {
        buyMapper.updatestarStatuss(postpone);
    }


}
