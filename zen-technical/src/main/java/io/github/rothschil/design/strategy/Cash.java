package io.github.rothschil.design.strategy;

public class Cash implements Payment{

    @Override
    public void payment() {
        System.out.println("现金付款");
    }
}
