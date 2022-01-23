package io.github.rothschil.design.builder.model1;

import io.github.rothschil.design.builder.Car;

public class ChiefEngineer {

    public Car create(Builder builder){
        builder.bulidChassis();
        builder.bulidEngine();
        builder.bulidElectrical();
        builder.bulidTires();
        builder.bulidTransmission();
        return builder.getCar();
    }
}
