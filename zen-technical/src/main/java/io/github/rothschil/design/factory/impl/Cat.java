package io.github.rothschil.design.factory.impl;

import io.github.rothschil.design.factory.Animals;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Cat implements Animals {

    @Override
    public void eat() {
        log.warn("猫吃老鼠");
    }

    @Override
    public void drink() {
        log.warn("猫喝水");
    }

    @Override
    public void move() {
        log.warn("猫用四肢走路");
    }
}
