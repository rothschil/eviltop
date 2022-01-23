package io.github.rothschil.design.factory;

import io.github.rothschil.design.abstractfactory.Color;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Red implements Color {

    @Override
    public void fill() {
        log.warn("填充红色");
    }
}
