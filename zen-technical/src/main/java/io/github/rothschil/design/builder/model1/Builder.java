package io.github.rothschil.design.builder.model1;

import io.github.rothschil.design.builder.Car;

/** 工种
 * @author <a href="https://github.com/rothschil">Sam</a>
 * @date 2022/1/14 - 14:17
 * @since 1.0.0
 */
public interface Builder {

    void bulidEngine();

    void bulidTires();

    void bulidChassis();

    void bulidTransmission();

    void bulidElectrical();

    Car getCar();
}
