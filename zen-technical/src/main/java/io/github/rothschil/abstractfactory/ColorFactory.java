package io.github.rothschil.abstractfactory;

import io.github.rothschil.design.factory.Green;
import io.github.rothschil.design.factory.Red;
import io.github.rothschil.design.factory.Steel;

public class ColorFactory extends AbstractFactory {

    @Override
    public Color getColor(int type){
        switch (type){
            case 1: return new Red();
            case 2: return new Green();
            default: return new Blue();
        }
    }

    @Override
    public Steel getSteel(int type) {
        return null;
    }
}
