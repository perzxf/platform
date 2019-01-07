package com.jb.model;

import lombok.Data;


@Data
public class TMaterial {
  private String id;
  private String category;
  private String materialname;
  private String materialnumber;
  private Integer count;
  private String brand;
  private Integer unitprice;
  private String custommadeprid;
  private String annexid;
  private String remarks;
  private String effectivetime;
  private String supplyperiod;
  private Integer status;
  private Integer page;
  private Integer rows;
}
