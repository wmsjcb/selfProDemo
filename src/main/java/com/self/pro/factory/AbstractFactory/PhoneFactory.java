package com.self.pro.factory.AbstractFactory;

import com.self.pro.factory.Apple;
import com.self.pro.factory.HuaWei;
import com.self.pro.factory.Phone;
import com.self.pro.factory.SanXing;

public class PhoneFactory extends AbstractPhoneFactory {
    @Override
    public Phone getHuaWei() {
        return new HuaWei();
    }

    @Override
    public Phone getSanXing() {
        return new SanXing();
    }

    @Override
    public Phone getApple() {
        return new Apple();
    }
}
