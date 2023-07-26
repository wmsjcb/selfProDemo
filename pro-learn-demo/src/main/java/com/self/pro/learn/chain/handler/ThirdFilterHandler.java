package com.self.pro.learn.chain.handler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThirdFilterHandler extends AbstractFilterHandler {

    static final int THIRD_SCOPE = 90;

    @Override
    public int handler() {
        log.error("第三环节处理");
        int score = third();
        if(score>=THIRD_SCOPE){
            log.error("处理完毕，交由下一环节处理");
        }else{
            log.error("处理不了，交由下一环节处理");
            if(this.next != null){
                return this.next.handler();
            }
        }
        return score;
    }

    private int third(){
        return THIRD_SCOPE;
    }
}