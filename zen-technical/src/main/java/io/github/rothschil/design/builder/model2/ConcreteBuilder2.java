package io.github.rothschil.design.builder.model2;

import io.github.rothschil.design.builder.Car;

public class ConcreteBuilder2 implements Builder2 {

    private Car car;

    public ConcreteBuilder2(Car car) {
        this.car = car;
    }

    @Override
    public Builder2 engine() {
        car.setEngine("制造引擎");
        return this;
    }

    @Override
    public Builder2 tires() {
        car.setTires("制造轮子");
        return this;
    }

    @Override
    public Builder2 chassis() {
        car.setChassis("制造底盘");
        return this;
    }

    @Override
    public Builder2 transmission() {
        car.setTransmission("制造传动");
        return this;
    }

    @Override
    public Builder2 electrical() {
        car.setElectrical("制造电气设备");
        return this;
    }

    @Override
    public Car build() {
        return car;
    }
}
