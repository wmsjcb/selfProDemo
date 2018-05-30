package com.self.pro.prototype.deep2;

/**
 * Created by chenbinbin1 on 2018/5/30.
 */
public class ClientTest {
    public static void main(String[] args) {
        // 1.构建书本对象
        BookRead read1 = new  BookRead();
        // 2.编辑书本，添加图片
        read1.setTitle("书1");
        read1.addImage("图1");
        read1.showBook();
        // 以原型文档为原型，拷贝一份副本
        BookRead read2 = null;
        try {
            read2 = (BookRead) read1.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        read2.showBook();
        // 修改图书副本，不会影响原始书本
        read2.setTitle("书2");
        read2.addImage("图2");
        read2.showBook();

        // 再次打印原始书本
        read1.showBook();


    }

}
