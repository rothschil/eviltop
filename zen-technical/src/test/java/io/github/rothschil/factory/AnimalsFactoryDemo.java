package io.github.rothschil.factory;

import io.github.rothschil.BaseTest;
import io.github.rothschil.design.factory.Animals;
import io.github.rothschil.design.factory.AnimalsFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
public class AnimalsFactoryDemo extends BaseTest {

    @DisplayName("工厂模式")
    @Test
    public void testFactory(){
        Animals animals = new AnimalsFactory().getAnimals("Cat");
        animals.eat();
        animals.drink();
        animals.move();
    }
}
