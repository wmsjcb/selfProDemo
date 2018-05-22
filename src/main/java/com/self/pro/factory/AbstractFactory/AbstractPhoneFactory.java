package com.self.pro.factory.AbstractFactory;

import com.self.pro.factory.HuaWei;
import com.self.pro.factory.Phone;
import com.self.pro.factory.methodFactory.HuaWeiFactory;

public abstract class AbstractPhoneFactory {

    public abstract Phone getHuaWei();
    public abstract Phone getSanXing();
    public abstract  Phone getApple();

}
