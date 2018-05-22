package com.self.pro.factory.methodFactory;

import com.self.pro.factory.Phone;
import com.self.pro.factory.SanXing;

/**
 * Created by chenbinbin1 on 2018/5/22.
 */
public class SanXingFactory implements Phone {

    @Override
    public String getName() {
        return new SanXing().getName();
    }
}
