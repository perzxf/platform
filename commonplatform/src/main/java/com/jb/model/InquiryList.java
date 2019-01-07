package com.jb.model;

import lombok.Data;

@Data
public class InquiryList {
    private String id;
    private Integer expectedTotalPriceint;
    private Integer paymentNode;
    private String paymentRatio;
    private Integer paymentDays;
    private String invoiceType;
    private String taxRate;
    private String billingType;
    private String settlement;
    private String modeOfDistribution;
    private String shippingAddress;
    private String purchasingDepartment;
    private String defaultFactory;
    private String defaultWarehouse;
    private String remarkSection;
    private String prId;

}
