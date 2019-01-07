package com.jb.model;

import lombok.Data;

@Data
public class TServiceQuotation {

  private String id;
  private String name;//服务名称
  private String price;//价格
  private String customMadePrId;//定制比价管理Id
  private String status;//状态


}
