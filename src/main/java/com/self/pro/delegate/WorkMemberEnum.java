package com.self.pro.delegate;


public enum  WorkMemberEnum {
    A(new MemberA()),B(new MemberB()),C(new MemberC());
    private ITarget target;

    WorkMemberEnum(ITarget target){
        this.target=target;
    }

    public ITarget getTarget() {
        return target;
    }

    public void setTarget(ITarget target) {
        this.target = target;
    }
}
