package com.self.pro.strategy;

/**
 * Created by chenbinbin1 on 2018/6/1.
 */
public class PayTest {
    public static void main(String[] args) {
        Order order = new Order("1",23.54);
       // AliPay aliPay = new AliPay();
       // PayMent payMent = new JdPay();//new AliPay();
        PayState payState = order.pay(PayType.Alipay);
        System.out.println(payState);

        //PayMent payMent = new AliPay().pay()


    }
}
