package com.self.pro.proxy.staticed;

/**
 * Created by chenbinbin1 on 2018/5/30.
 */
public class Father {
    private  Son son;
    public Father(Son son){
     this.son=son;
    }


    public  void findLove(){
        System.out.println("老爸开始出马，说条件");
        son.findLove();
        System.out.println("没问题保你满意");
    }


}
