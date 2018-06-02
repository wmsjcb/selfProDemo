package com.self.pro.adapter;

public class LoginForThree extends LoginStand {
    @Override
    public void regist() {
        System.out.println("我是三方注册,需要把我的数据写到你的库中");
        super.regist();

    }

    @Override
    public void login() {
        System.out.println("我是三方登陆,需要从到你的库中读取登陆数据");
        super.login();
    }

    public  void loginForQQ(){
        System.out.println("我是qq登陆");
        super.login();
    }


}
