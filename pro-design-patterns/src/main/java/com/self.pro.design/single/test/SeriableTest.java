package com.self.pro.design.single.test;


import com.self.pro.design.single.seriable.Seriable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SeriableTest {
    public static void main(String[] args) {
        Seriable s1 = null;
        Seriable s2 = Seriable.getInstace();
        FileOutputStream fos = null;
        try{
            fos = new FileOutputStream("Seriable.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s2);
            oos.flush();
            oos.close();

            FileInputStream fis = new FileInputStream("Seriable.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            s1 = (Seriable)ois.readObject();
            ois.close();
            System.out.println(s1);
            System.out.println(s2);
            System.out.println(s1 == s2);

        }catch (Exception e){
          e.printStackTrace();
        }

    }
}
