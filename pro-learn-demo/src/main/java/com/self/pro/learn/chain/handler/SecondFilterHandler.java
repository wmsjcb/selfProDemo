package com.self.pro.learn.chain.handler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SecondFilterHandler extends AbstractFilterHandler {

    static final int SECOND_SCOPE = 80;

    @Override
    public int handler() {
        log.error("第二环节处理");
        int score = second();
        if(score>=SECOND_SCOPE){
            log.error("处理完毕，交由下一环节处理");
            if(this.next != null){
                return this.next.handler();
            }
        }else{
            log.error("处理不了，交由下一环节处理");
        }
        return score;
    }

    private int second(){
        return SECOND_SCOPE;
    }
}