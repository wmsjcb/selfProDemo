package com.self.pro.prototype.simple;

import java.util.ArrayList;
import java.util.List;

public class Prototype implements Cloneable{
    private String name;

    private List<String> ls = new ArrayList<>();

    private  CloneTarget cloneTarget=null;


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

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

    public List<String> getLs() {
        return ls;
    }

    public void setLs(List<String> ls) {
        this.ls = ls;
    }
}
