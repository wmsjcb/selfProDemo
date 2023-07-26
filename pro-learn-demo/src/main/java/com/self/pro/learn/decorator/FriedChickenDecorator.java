package com.self.pro.learn.decorator;

import com.self.pro.learn.decorator.service.FriedChicken;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author liha
 * @Date 2022-03-27 19:23
 * 李哈YYDS
 */
@Service("friedChickenDecorator")
public class FriedChickenDecorator implements FriedChicken {
 
    // 内部维护一个炸鸡类
    @Resource(name = "mc")
    private FriedChicken friedChicken;
    // 通过构造方法把需要装饰的炸鸡类传进来
//    public FriedChickenDecorator(FriedChicken friedChicken) {
//        this.friedChicken = friedChicken;
//    }
 
    // 增强方法
    @Override
    public void makeFriedChicken() {
 
//        friedChicken.makeFriedChicken();
        System.out.println("检查炸鸡是否存在问题");
    }
}