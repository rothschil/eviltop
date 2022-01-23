package io.github.rothschil.design.builder.model1;

import io.github.rothschil.design.builder.Car;

public class ConcreteBuilder implements Builder {

    private Car car;

    public ConcreteBuilder(Car car) {
        this.car = car;
    }

    @Override
    public void bulidEngine() {
        car.setEngine("制造引擎");
    }

    @Override
    public void bulidTires() {
        car.setTires("制造轮子");
    }

    @Override
    public void bulidChassis() {
        car.setChassis("制造底盘");
    }

    @Override
    public void bulidTransmission() {
        car.setTransmission("制造传动");
    }

    @Override
    public void bulidElectrical() {
        car.setElectrical("制造电气设备");
    }

    @Override
    public Car getCar() {
        return car;
    }
}
