package io.github.rothschil.design.factory;

import io.github.rothschil.abstractfactory.Color;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Green implements Color {

    @Override
    public void fill() {
        log.warn("填充绿色");
    }
}
