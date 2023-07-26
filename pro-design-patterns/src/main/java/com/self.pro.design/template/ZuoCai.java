package com.self.pro.design.template;

/**
 * Created by chenbinbin1 on 2018/6/1.
 */
public abstract class ZuoCai {

    protected  void zuofan(){
        this.beiLiao();
        this.zuocai();
        this.shangcai();
    }
    //固定的步骤

    //1、备料
      abstract void beiLiao();

    //2、做菜
    abstract void zuocai();

    //3、上菜
    abstract void shangcai();
}
