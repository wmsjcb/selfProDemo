package com.self.pro.single.register;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenbinbin1 on 2018/5/25.
 */
public class RegisterMap {
    private RegisterMap (){}

    private static  Map<String,Object> registerMap = new HashMap<String,Object>();
    public static  RegisterMap getInstance(String name){
      if(name == null || name.equals("")){
              name= RegisterMap.class.getName();
      }
      if(registerMap.get(name)==null || registerMap.get(name).equals("")){
          try {
              registerMap.put(name,new RegisterMap());
          }catch (Exception e){
              e.printStackTrace();
          }
      }

      return  (RegisterMap) registerMap.get(name);
    }

}
