package com.self.pro.delegate;

public class Leader {


   public void  doLeadWork(WorkMemberEnum memberEnum, String command){
       memberEnum.getTarget().doWork(command);
    }
}
