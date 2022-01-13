package io.github.rothschil.design.factory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Car implements Steel{



    @Override
    public void manufacturing(int count) {
        log.warn("制造汽车 数量 {}",count/10);
    }
}
