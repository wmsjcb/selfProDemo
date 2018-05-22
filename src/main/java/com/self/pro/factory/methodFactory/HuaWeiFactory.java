package com.self.pro.factory.methodFactory;


import com.self.pro.factory.HuaWei;
import com.self.pro.factory.Phone;

/**
 * Created by chenbinbin1 on 2018/5/22.
 */
public class HuaWeiFactory implements Phone {

    @Override
    public String getName() {
        return new HuaWei().getName();
    }
}
