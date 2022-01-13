package io.github.rothschil.design.strategy;

public class Credit implements Payment{

    @Override
    public void payment() {
        System.out.println("信用卡付款");
    }
}
