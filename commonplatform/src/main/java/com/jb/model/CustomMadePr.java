package com.jb.model;

import lombok.Data;

@Data
public class CustomMadePr {
  private String id; //项目编码
  private String billOfMaterialsId; //材料单ID
  private String typeId; //状态ID
  private String startime;//开始时间
  private String time; //报价结束时间
  private Integer orderSize; //采购数量
  private Integer itemstarstatus; //买家状态
  private String bomName; //项目名称
  private String beginTime;
  private String endTime;
  private String ttName; //状态
  private String tcName; //渠道名称
  private String tcId; //渠道ID
  private String materialId; //物料Id
  private String serviceId; //服务报价Id
  private String annexId; //附件id
  private Integer status; //状态 （买家1 卖家2 服务商3）
  private String billTime;//材料单保存时间
  private String category;         //类目
  private String materialname;     //物类名称
  private String materialnumber;   //物类编号
  private Integer count;           //数量
  private String brand;            //品牌
  private Integer unitprice;       //单价
  private String name;//服务名称
  private String price;//价格
  private Integer page;
  private Integer rows;
  private String remarks;
  private String supplyperiod;
  private String effectivetime;


}
