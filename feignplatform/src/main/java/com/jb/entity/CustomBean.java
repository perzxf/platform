package com.jb.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "platform",type = "elplatform")
public class CustomBean {
    @Id
    private String id; //项目编码
    @Field(analyzer = "ik_smart",type = FieldType.Text,store = true)
    private String billOfMaterialsId; //材料单ID
    @Field(analyzer = "ik_smart",type = FieldType.Text,store = true)
    private String typeId; //状态ID
    @Field(analyzer = "ik_smart",type = FieldType.Text,store = true)
    private String startime;//开始时间
    @Field(analyzer = "ik_smart",type = FieldType.Text,store = true)
    private String time; //报价结束时间
    @Field(analyzer = "ik_smart",type = FieldType.Text,store = true)
    private Integer orderSize; //采购数量
    @Field(analyzer = "ik_smart",type = FieldType.Text,store = true)
    private Integer itemstarstatus; //买家状态
    @Field(analyzer = "ik_smart",type = FieldType.Text,store = true)
    private String bomName; //项目名称
    @Field(analyzer = "ik_smart",type = FieldType.Text,store = true)
    private String beginTime;
    @Field(analyzer = "ik_smart",type = FieldType.Text,store = true)
    private String endTime;
    @Field(analyzer = "ik_smart",type = FieldType.Text,store = true)
    private String ttName; //状态
    @Field(analyzer = "ik_smart",type = FieldType.Text,store = true)
    private String tcName; //渠道名称
    @Field(analyzer = "ik_smart",type = FieldType.Text,store = true)
    private String tcId; //渠道ID
    @Field(analyzer = "ik_smart",type = FieldType.Text,store = true)
    private String materialId; //物料Id
    @Field(analyzer = "ik_smart",type = FieldType.Text,store = true)
    private String serviceId; //服务报价Id
    @Field(analyzer = "ik_smart",type = FieldType.Text,store = true)
    private String annexId; //附件id
    @Field(analyzer = "ik_smart",type = FieldType.Text,store = true)
    private Integer status; //状态 （买家1 卖家2 服务商3）
    @Field(analyzer = "ik_smart",type = FieldType.Text,store = true)
    private String billTime;//材料单保存时间
    @Field(analyzer = "ik_smart",type = FieldType.Text,store = true)
    private String category;         //类目
    @Field(analyzer = "ik_smart",type = FieldType.Text,store = true)
    private String materialname;     //物类名称
    @Field(analyzer = "ik_smart",type = FieldType.Text,store = true)
    private String materialnumber;   //物类编号
    @Field(analyzer = "ik_smart",type = FieldType.Text,store = true)
    private Integer count;           //数量
    @Field(analyzer = "ik_smart",type = FieldType.Text,store = true)
    private String brand;            //品牌
    @Field(analyzer = "ik_smart",type = FieldType.Text,store = true)
    private Integer unitprice;       //单价
    @Field(analyzer = "ik_smart",type = FieldType.Text,store = true)
    private String name;//服务名称
    @Field(analyzer = "ik_smart",type = FieldType.Text,store = true)
    private String price;//价格
    @Field(analyzer = "ik_smart",type = FieldType.Text,store = true)
    private String remarks;
    @Field(analyzer = "ik_smart",type = FieldType.Text,store = true)
    private String supplyperiod;
    @Field(analyzer = "ik_smart",type = FieldType.Text,store = true)
    private String effectivetime;
    @Field(analyzer = "ik_smart",type = FieldType.Text,store = true)
    private Integer page;
    @Field(analyzer = "ik_smart",type = FieldType.Text,store = true)
    private Integer rows;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBillOfMaterialsId() {
        return billOfMaterialsId;
    }

    public void setBillOfMaterialsId(String billOfMaterialsId) {
        this.billOfMaterialsId = billOfMaterialsId;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getStartime() {
        return startime;
    }

    public void setStartime(String startime) {
        this.startime = startime;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getOrderSize() {
        return orderSize;
    }

    public void setOrderSize(Integer orderSize) {
        this.orderSize = orderSize;
    }

    public Integer getItemstarstatus() {
        return itemstarstatus;
    }

    public void setItemstarstatus(Integer itemstarstatus) {
        this.itemstarstatus = itemstarstatus;
    }

    public String getBomName() {
        return bomName;
    }

    public void setBomName(String bomName) {
        this.bomName = bomName;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getTtName() {
        return ttName;
    }

    public void setTtName(String ttName) {
        this.ttName = ttName;
    }

    public String getTcName() {
        return tcName;
    }

    public void setTcName(String tcName) {
        this.tcName = tcName;
    }

    public String getTcId() {
        return tcId;
    }

    public void setTcId(String tcId) {
        this.tcId = tcId;
    }

    public String getMaterialId() {
        return materialId;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getAnnexId() {
        return annexId;
    }

    public void setAnnexId(String annexId) {
        this.annexId = annexId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getBillTime() {
        return billTime;
    }

    public void setBillTime(String billTime) {
        this.billTime = billTime;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMaterialname() {
        return materialname;
    }

    public void setMaterialname(String materialname) {
        this.materialname = materialname;
    }

    public String getMaterialnumber() {
        return materialnumber;
    }

    public void setMaterialnumber(String materialnumber) {
        this.materialnumber = materialnumber;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(Integer unitprice) {
        this.unitprice = unitprice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getSupplyperiod() {
        return supplyperiod;
    }

    public void setSupplyperiod(String supplyperiod) {
        this.supplyperiod = supplyperiod;
    }

    public String getEffectivetime() {
        return effectivetime;
    }

    public void setEffectivetime(String effectivetime) {
        this.effectivetime = effectivetime;
    }

    @Override
    public String toString() {
        return "CustomBean{" +
                "id='" + id + '\'' +
                ", billOfMaterialsId='" + billOfMaterialsId + '\'' +
                ", typeId='" + typeId + '\'' +
                ", startime='" + startime + '\'' +
                ", time='" + time + '\'' +
                ", orderSize=" + orderSize +
                ", itemstarstatus=" + itemstarstatus +
                ", bomName='" + bomName + '\'' +
                ", beginTime='" + beginTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", ttName='" + ttName + '\'' +
                ", tcName='" + tcName + '\'' +
                ", tcId='" + tcId + '\'' +
                ", materialId='" + materialId + '\'' +
                ", serviceId='" + serviceId + '\'' +
                ", annexId='" + annexId + '\'' +
                ", status=" + status +
                ", billTime='" + billTime + '\'' +
                ", category='" + category + '\'' +
                ", materialname='" + materialname + '\'' +
                ", materialnumber='" + materialnumber + '\'' +
                ", count=" + count +
                ", brand='" + brand + '\'' +
                ", unitprice=" + unitprice +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", remarks='" + remarks + '\'' +
                ", supplyperiod='" + supplyperiod + '\'' +
                ", effectivetime='" + effectivetime + '\'' +
                ", page=" + page +
                ", rows=" + rows +
                '}';
    }
}
