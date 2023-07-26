package com.aop.test.flow.handler;

import com.self.pro.learn.ProDemoApplication;
import com.self.pro.learn.chain.handler.AbstractFilterHandler;
import com.self.pro.learn.util.SpringContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProDemoApplication.class)
public class HandlerTest {
    @Test
    public void testProcess() {
        List<AbstractFilterHandler> handlerList = new LinkedList<>();
        List<String> handlerConfigList = new ArrayList<>();
        handlerConfigList.add("firstFilterHandler");
        handlerConfigList.add("secondFilterHandler");
        handlerConfigList.add("thirdFilterHandler");
        for (String handler: handlerConfigList) {
            handlerList.add((AbstractFilterHandler) SpringContextUtil.getBean(handler));
        }


//        Map<String, AbstractFilterHandler> filterMap = new LinkedHashMap<>();
//        filterMap.put("first", new FirstFilterHandler());
//        filterMap.put("second", new SecondFilterHandler());
//        filterMap.put("third", new ThirdFilterHandler());
        try {
//            for (Map.Entry<String, AbstractFilterHandler> handlerEntry : filterMap.entrySet()) {
//                handlerEntry.getValue().handler();
//            }
            for (AbstractFilterHandler handler : handlerList) {
                handler.handler();
            }

        }catch (Exception e){
            log.error(">>>>>>>>>>>>>>chain fail", e);
            e.printStackTrace();
        }


//        ChainImpl<DismissHandler, DismissDTO> dismissHandlerStringChain = new ChainImpl<>(dismissHandlers);
//        dismissHandlerStringChain.doHandler(DismissDTO.builder().userId(userId).groupId(groupId).build());

    }

}