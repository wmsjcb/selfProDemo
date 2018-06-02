package com.self.pro.delegate;

public class Boss {
    //老板让项目经理干活，可以引用项目经理接口，便于扩展（代理模式）
    public static void main(String[] args) {
        Leader leader = new Leader();
        leader.doLeadWork(WorkMemberEnum.B,"加密");

    }
}
