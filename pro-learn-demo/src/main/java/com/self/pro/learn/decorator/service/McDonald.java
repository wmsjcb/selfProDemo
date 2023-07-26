package com.self.pro.learn.decorator.service;

import org.springframework.stereotype.Service;

@Service("mc")
public class McDonald implements FriedChicken{
 
    @Override
    public void makeFriedChicken() {
        System.out.println("麦当劳制作了一份炸鸡");
    }
}