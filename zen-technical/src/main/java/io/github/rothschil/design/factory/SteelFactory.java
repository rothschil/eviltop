package io.github.rothschil.design.factory;

import io.github.rothschil.abstractfactory.Car;

public class SteelFactory {

    public Steel getSteel(int type){
        switch (type){
            case 1: return new Car();
            case 2: return new Knife();
            default: return new Bicycles();
        }
    }
}
