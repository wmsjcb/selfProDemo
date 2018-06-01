package com.self.pro.strategy;

/**
 * Created by chenbinbin1 on 2018/6/1.
 */
public class PayState {

    private  int code;
    private  String msg;
    private Object data;

    public PayState(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    @Override
    public String toString() {
        return ("支付状态：[" + code + "]," + msg + ",交易详情：" + data);
    }
}
