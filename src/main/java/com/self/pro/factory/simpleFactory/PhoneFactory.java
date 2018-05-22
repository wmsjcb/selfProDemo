package com.self.pro.factory.simpleFactory;

import com.self.pro.factory.Apple;
import com.self.pro.factory.HuaWei;
import com.self.pro.factory.SanXing;

/**
 * Created by chenbinbin1 on 2018/5/22.
 */
public class PhoneFactory {

    public String getPhoneName(String name){
        if(name.equals("huawei")){
            return new HuaWei().getName();

        }else if(name.equals("sanxing")){
            return new SanXing().getName();
        }else if(name.equals("apple")){
            return new Apple().getName();
        }
      return null;
    }


     //String getName(String name);
}
