package com.self.pro.learn.example.entity;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @Author:0xOO
 * @Date: 2018/9/26 0026
 * @Time: 14:39
 */
public class User {
    @Id
    private Integer id;
    @Column(name = "userName")
    private String userName;
    @Column(name = "passWord")
    private String passWord;
    @Column(name = "realName")
    private String realName;
    @Column(name = "age")
    private Integer age;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", realName='" + realName + '\'' +
                '}';
    }
}
