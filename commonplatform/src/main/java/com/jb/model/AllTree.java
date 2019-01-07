package com.jb.model;

import lombok.Data;

import java.util.List;

@Data
public class AllTree {

  private String id;
  private String text;
  private String pid;
  private String href;
  private String status;
  private Boolean selectable;
  private List<AllTree> nodes;


}
