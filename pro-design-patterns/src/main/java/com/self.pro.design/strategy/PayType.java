package com.self.pro.design.strategy;

/**
 * Created by chenbinbin1 on 2018/6/1.
 */
public enum  PayType {
    Alipay(new AliPay()),JdPay(new JdPay());
    private PayMent payMent;

     PayType(PayMent payMent){
     this.payMent=payMent;
    }

    public PayMent getPayMent() {
        return payMent;
    }

    public void setPayMent(PayMent payMent) {
        this.payMent = payMent;
    }
}
