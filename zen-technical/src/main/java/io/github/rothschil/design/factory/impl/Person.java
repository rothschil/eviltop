package io.github.rothschil.design.factory.impl;

import io.github.rothschil.design.factory.Animals;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Person implements Animals {

    @Override
    public void eat() {
        log.warn("人类吃干净卫生的食物");
    }

    @Override
    public void drink() {
        log.warn("人类喝健康的水");
    }

    @Override
    public void move() {
        log.warn("人类出行有交通工具");
    }
}
