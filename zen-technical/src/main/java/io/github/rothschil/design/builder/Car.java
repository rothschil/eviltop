package io.github.rothschil.design.builder;

/**
 * 汽车
 *
 * @author <a href="https://github.com/rothschil">Sam</a>
 * @date 2022/1/14 - 14:17
 * @since 1.0.0
 */
public class Car {

    /**
     * 动力引擎
     */
    private String engine;

    /**
     * 轮胎
     */
    private String tires;

    /**
     * 底盘
     */
    private String chassis;

    /**
     * 传动
     */
    private String transmission;

    /**
     * 电气
     */
    private String electrical;

    @Override
    public String toString() {
        return "Car{" +
                "engine='" + engine + '\'' +
                ", tires='" + tires + '\'' +
                ", chassis='" + chassis + '\'' +
                ", transmission='" + transmission + '\'' +
                ", electrical='" + electrical + '\'' +
                '}';
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getTires() {
        return tires;
    }

    public void setTires(String tires) {
        this.tires = tires;
    }

    public String getChassis() {
        return chassis;
    }

    public void setChassis(String chassis) {
        this.chassis = chassis;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getElectrical() {
        return electrical;
    }

    public void setElectrical(String electrical) {
        this.electrical = electrical;
    }
}
