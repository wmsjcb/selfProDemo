package com.self.pro.learn.aop.service;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service("userService")
@Repository
public class UserService {

    public String getUserById(Integer id){
        System.out.println("getUserById");
        return "user_test";
    }
    public void deleteUserById(Integer id){
        System.out.println("delete id: "+id);
    }
}

