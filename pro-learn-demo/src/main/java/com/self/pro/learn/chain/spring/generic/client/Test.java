package com.self.pro.learn.chain.spring.generic.client;

import com.self.pro.learn.chain.spring.generic.dto.DismissDTO;
import com.self.pro.learn.chain.spring.generic.handler.DismissHandler;
import com.self.pro.learn.chain.spring.generic.handler.DismissHandler1;
import com.self.pro.learn.chain.spring.generic.handler.DismissHandler2;
import com.self.pro.learn.chain.spring.generic.service.impl.ChainImpl;

import java.util.ArrayList;
import java.util.List;

public class Test {
    private List<DismissHandler> dismissHandlers;

    public static void main(String[] args) {
        List<DismissHandler> dismissHandlers = new ArrayList<>();
        dismissHandlers.add(new DismissHandler1());
        dismissHandlers.add(new DismissHandler2());
        ChainImpl<DismissHandler, DismissDTO> dismissHandlerStringChain = new ChainImpl<>(dismissHandlers);
        dismissHandlerStringChain.doHandler(DismissDTO.builder().userId(1L).groupId(2L).build());
    }

}
