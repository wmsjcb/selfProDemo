package com.self.pro.design.delegate;

public class Leader {


   public void  doLeadWork(WorkMemberEnum memberEnum, String command){
       memberEnum.getTarget().doWork(command);
    }
}
