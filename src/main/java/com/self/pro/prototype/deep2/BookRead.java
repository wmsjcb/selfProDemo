package com.self.pro.prototype.deep2;

import java.util.ArrayList;

/*
 * 书本类型，扮演的是ConcretePrototype角色，而Cloneable扮演Prototype角色
 */
public class BookRead implements Cloneable {

    private String title;// 标题
    private ArrayList<String> image = new ArrayList<String>();// 图片名列表

    public BookRead() {
        super();
    }

    /**
     * 重写拷贝方法
     */
    @Override
    protected BookRead clone()  {
        try {
            BookRead read = (BookRead) super.clone();
            // 对image对象也调用clone()函数，进行拷贝
            read.image = (ArrayList<String>) this.image.clone();
            return read;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<String> getImage() {
        return image;
    }

    public void addImage(String img) {
        this.image.add(img);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 打印内容
     */
    public void showBook() {
        System.out.println("----------------------Start----------------------");

        System.out.println("title：" + title);
        for (String img : image) {
            System.out.println("image name:" + img);
        }

        System.out.println("----------------------End----------------------");
    }
}