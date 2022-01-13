package io.github.rothschil.abstractfactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Blue implements Color{

    @Override
    public void fill() {
        log.warn("填充蓝色");
    }
}
