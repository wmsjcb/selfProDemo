package com.self.pro.learn.example.service;

import com.self.pro.learn.example.mapper.DumpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author:0xOO
 * @Date: 2018/9/26 0026
 * @Time: 15:23
 */
@Service
public class DumpService {
    @Autowired
    private DumpMapper dumpMapper;
    public void  dumpData() {
        try {
            //        dumpMapper.backupLog("2022-12-13 02:13:28","sys_user_history","sys_user");

            dumpMapper.backupLog("2024-12-13 02:13:28","sys_config_history","sys_config");
        } catch (Exception e) {
            e.printStackTrace();
        }




    }
}
