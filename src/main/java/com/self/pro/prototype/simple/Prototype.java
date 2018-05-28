package com.self.pro.prototype.simple;

public class Prototype implements Cloneable{
    private String name;

    private  CloneTarget cloneTarget=null;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CloneTarget getCloneTarget() {
        return cloneTarget;
    }

    public void setCloneTarget(CloneTarget cloneTarget) {
        this.cloneTarget = cloneTarget;
    }
}
