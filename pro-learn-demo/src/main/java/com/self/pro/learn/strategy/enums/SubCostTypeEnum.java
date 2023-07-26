package com.self.pro.learn.strategy.enums;

public enum SubCostTypeEnum {
 
    GREATER0_IN_0UP(7, "原始>0，入库后>0"),
    EQUAL0_OUT_0DOWN(8, "原始=0，出库后<0"),
 
    ;
 
    private Integer value;
    private String description;
 
    private SubCostTypeEnum(Integer value, String description) {
        this.value = value;
        this.description = description;
    }
 
    public Integer value() {
        return value;
    }
 
    public String description() {
        return description;
    }
 
    public static SubCostTypeEnum valueOf(Integer value) {
        for(SubCostTypeEnum type : SubCostTypeEnum.values()) {
            //if(type.value() == value) {
            if(type.value().equals(value)) {
                return type;
            }
        }
        return null;
    }
}