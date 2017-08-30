package com.luwei.mq;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import com.google.common.collect.Maps;

public class InvestResult {
	
	
	
    private Long userId;
    private String username;
    private Long productId;
    private String productName;
    private Integer productType;
    private BigDecimal amount;
    private Date investTime;
    private Long investId;
    private Integer investStatus;
    private String channel;
    private Integer investSequence;
    private Map<String, String> extendParamMap = Maps.newHashMap();
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public Long getProductId() {
        return productId;
    }
    public void setProductId(Long productId) {
        this.productId = productId;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public Integer getProductType() {
        return productType;
    }
    public void setProductType(Integer productType) {
        this.productType = productType;
    }
    public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    public Date getInvestTime() {
        return investTime;
    }
    public void setInvestTime(Date investTime) {
        this.investTime = investTime;
    }
    public Long getInvestId() {
        return investId;
    }
    public void setInvestId(Long investId) {
        this.investId = investId;
    }
    public Integer getInvestStatus() {
        return investStatus;
    }
    public void setInvestStatus(Integer investStatus) {
        this.investStatus = investStatus;
    }
    public String getChannel() {
        return channel;
    }
    public void setChannel(String channel) {
        this.channel = channel;
    }
    public Integer getInvestSequence() {
        return investSequence;
    }
    public void setInvestSequence(Integer investSequence) {
        this.investSequence = investSequence;
    }
    public Map<String, String> getExtendParamMap() {
        return extendParamMap;
    }
    public void setExtendParamMap(Map<String, String> extendParamMap) {
        this.extendParamMap = extendParamMap;
    }
    
    
    
}

