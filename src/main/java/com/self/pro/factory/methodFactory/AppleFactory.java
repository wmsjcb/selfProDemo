package com.self.pro.factory.methodFactory;

import com.self.pro.factory.Apple;
import com.self.pro.factory.Phone;

/**
 * Created by chenbinbin1 on 2018/5/22.
 */
public class AppleFactory implements Phone {

    @Override
    public String getName() {
        return new Apple().getName();
    }
}
