package com.self.pro.design.prototype.deep;

import java.io.*;

/**
 * Created by chenbinbin1 on 2018/5/31.
 */
public class Email implements Cloneable,Serializable{
    private  String name;
    private Address address;
    //浅克隆
    @Override
    protected Email clone() throws CloneNotSupportedException {
        return (Email) super.clone();
    }

    //深克隆
    public Email deepClone() throws IOException, ClassNotFoundException {
        Email email = null;
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bo);
        oos.writeObject(this);

        ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
        ObjectInputStream oi = new ObjectInputStream(bi);
        email=(Email)oi.readObject();

        return email;

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
