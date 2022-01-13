package io.github.rothschil.design.strategy;

public class Points implements Payment{

    @Override
    public void payment() {
        System.out.println("积分付款");
    }
}
