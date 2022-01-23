package io.github.rothschil.design.factory.impl;

import io.github.rothschil.design.factory.Animals;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Dog implements Animals {

    @Override
    public void eat() {
        log.warn("狗吃骨头");
    }

    @Override
    public void drink() {
        log.warn("狗喝水");
    }

    @Override
    public void move() {
        log.warn("狗用四肢走路");
    }
}
