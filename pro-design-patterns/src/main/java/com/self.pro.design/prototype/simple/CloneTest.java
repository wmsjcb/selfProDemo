package com.self.pro.design.prototype.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenbinbin1 on 2018/5/29.
 */
public class CloneTest {
    public static void main(String[] args) {
        Prototype p = new Prototype();
        p.setName("1234");
        List<String> ls = new ArrayList<String>();
        ls.add("111");
        ls.add("22");
        p.setLs(ls);
        System.out.println(p+" "+p.getName());
        try {
            Prototype p2= (Prototype) p.clone();
            System.out.println(p2+" "+p2.getName()+"  "+p2.getLs());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }


//        CloneTarget c= new CloneTarget();
//         c.setName("wmsjcb");
//         c.setCloneTarget(new CloneTarget());
//        System.out.println(c.getCloneTarget());
//
//        try {
//            CloneTarget c2 = (CloneTarget) c.clone();
//            System.out.println(c2.getCloneTarget()+" "+c2.getName());
//        } catch (CloneNotSupportedException e) {
//            e.printStackTrace();
//        }


    }
}
