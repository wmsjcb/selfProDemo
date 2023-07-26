package com.self.pro.learn.decorator.service;

import org.springframework.stereotype.Service;

@Service("kfc")
public class KFC implements FriedChicken{
 
    @Override
    public void makeFriedChicken() {
        System.out.println("肯德基制作了一份炸鸡");
    }
}