package com.self.pro.design.factory.methodFactory;


import com.self.pro.design.factory.Apple;
import com.self.pro.design.factory.Phone;

/**
 * Created by chenbinbin1 on 2018/5/22.
 */
public class AppleFactory implements Factory {


    @Override
    public Phone getPhone() {
        return new Apple();
    }
}
