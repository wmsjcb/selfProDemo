package com.self.pro.learn.chain.handler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FirstFilterHandler extends AbstractFilterHandler {

    static final int FIRST_SCOPE = 70;

    @Override
    public int handler() {
        log.error("第一环节处理");
        int score = first();
        if(score>=FIRST_SCOPE){
            log.error("处理完毕，交由下一环节处理");
            if(this.next != null){
                return this.next.handler();
            }
        }else{
            log.error("处理不了，交由下一环节处理");
        }
        return score;
    }

    private int first(){
        return FIRST_SCOPE;
    }
}