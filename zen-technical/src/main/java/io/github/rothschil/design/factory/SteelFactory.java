package io.github.rothschil.design.factory;

public class SteelFactory {

    public Steel getSteel(int type){
        switch (type){
            case 1: return new Car();
            case 2: return new Knife();
            default: return new Bicycles();
        }
    }
}
