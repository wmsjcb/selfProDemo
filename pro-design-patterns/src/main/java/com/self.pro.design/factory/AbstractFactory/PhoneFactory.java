package com.self.pro.design.factory.AbstractFactory;


import com.self.pro.design.factory.Apple;
import com.self.pro.design.factory.HuaWei;
import com.self.pro.design.factory.Phone;
import com.self.pro.design.factory.SanXing;

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
