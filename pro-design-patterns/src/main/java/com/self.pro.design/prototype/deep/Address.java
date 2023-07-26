package com.self.pro.design.prototype.deep;

import java.io.Serializable;

/**
 * Created by chenbinbin1 on 2018/5/31.
 */
public class Address  implements Serializable{
    private  String province;
    public  Address(String province){
      this.province=province;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
