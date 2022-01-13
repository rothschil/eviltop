package io.github.rothschil.abstractfactory;

import io.github.rothschil.design.factory.Bicycles;
import io.github.rothschil.design.factory.Knife;
import io.github.rothschil.design.factory.Steel;

public class SteelFactory extends AbstractFactory {

    @Override
    public Steel getSteel(int type){
        switch (type){
            case 1: return new Car();
            case 2: return new Knife();
            default: return new Bicycles();
        }
    }

    @Override
    public Color getColor(int type) {
        return null;
    }
}
