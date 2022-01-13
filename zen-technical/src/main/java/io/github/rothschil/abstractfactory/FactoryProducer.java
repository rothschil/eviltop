package io.github.rothschil.abstractfactory;

public class FactoryProducer {

    public static AbstractFactory getAbstractFactory(int type){
        switch (type){
            case 1: return new ColorFactory();
            default: return new SteelFactory();
        }
    }
}
