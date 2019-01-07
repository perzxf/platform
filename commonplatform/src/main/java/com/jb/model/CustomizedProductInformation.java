package com.jb.model;

import lombok.Data;

@Data
public class CustomizedProductInformation {

  private String id;
  private String name;
  private Integer importMin;
  private Integer importMax;
  private Integer exitMin;
  private Integer exitMax;
  private Integer ratedFlow;
  private String regulatorKit;
  private String outerBox;
  private String boxMaterials;
  private String remarkSection;
  private String prId;

}
