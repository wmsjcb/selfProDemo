package com.self.pro.prototype.deep;

/**
 * Created by chenbinbin1 on 2018/5/31.
 */
public class EmailTest {
    public static void main(String[] args) {
        Email e1 = new Email();
        e1.setName("wmsjcb");
        Address adr = new Address("河南");
        e1.setAddress(adr);

        try {
            //浅克隆测试
//            Email e2 = (Email)e1.clone();
//            e2.getAddress().setProvince("河北");
//            Address adr2 = new Address("河北");
//            e2.setAddress(adr2);
//            System.out.println(e1==e2);
//            System.out.println(e1.getClass()+"  "+e2.getClass()+"  "+(e1.getClass()==e2.getClass()));
//            System.out.println(e1.getAddress()==e2.getAddress());
//             System.out.println("e2:"+e2+" name:"+e2.getName()+" adr2:"+e2.getAddress().getProvince());
//            System.out.println("e1:"+e1+" name:"+e1.getName()+" adr1:"+e1.getAddress().getProvince());
            System.out.println("------------------------");
            //深克隆测试
           Email  de1= e1.deepClone();
            de1.getAddress().setProvince("河北");
            System.out.println("adr1:"+e1.getAddress()+"  adr2:"+de1.getAddress());
            //System.out.println(e1==de1);
           // System.out.println("e1:"+e1 +"de1:"+de1 +"   "+(e1.getClass() ==de1.getClass()));
            System.out.println("de1:"+de1+" name:"+de1.getName()+" adr_de1:"+de1.getAddress().getProvince());
            System.out.println("e1:"+e1+" name:"+e1.getName()+" adr1:"+e1.getAddress().getProvince());


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
