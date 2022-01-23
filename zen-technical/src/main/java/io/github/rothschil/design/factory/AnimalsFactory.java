package io.github.rothschil.design.factory;

import io.github.rothschil.design.factory.impl.Cat;
import io.github.rothschil.design.factory.impl.Dog;
import io.github.rothschil.design.factory.impl.Person;

public class AnimalsFactory {

    public Animals getAnimals(String beanName) {
        if (beanName.equals(Cat.class.getSimpleName())) {
            return new Cat();
        } else if (beanName.equals(Dog.class.getSimpleName())) {
            return new Dog();
        } else if (beanName.equals(Person.class.getSimpleName())) {
            return new Person();
        }
        return null;
    }

}
