package io.github.rothschil.design;

import io.github.rothschil.design.abstractfactory.AbstractFactory;
import io.github.rothschil.design.abstractfactory.Color;
import io.github.rothschil.design.abstractfactory.FactoryProducer;
import io.github.rothschil.design.adapter.StandardAdapter;
import io.github.rothschil.design.builder.Car;
import io.github.rothschil.design.builder.model1.ChiefEngineer;
import io.github.rothschil.design.builder.model1.ConcreteBuilder;
import io.github.rothschil.design.builder.model2.ConcreteBuilder2;
import io.github.rothschil.design.decorator.demo.Component;
import io.github.rothschil.design.decorator.demo.ConcreteComponent;
import io.github.rothschil.design.decorator.demo.ConcreteDecorator;
import io.github.rothschil.design.decorator.war3.Changer2Girl;
import io.github.rothschil.design.decorator.war3.Changer2Succubus;
import io.github.rothschil.design.decorator.war3.DmHunter;
import io.github.rothschil.design.decorator.war3.Original;
import io.github.rothschil.design.factory.Steel;
import io.github.rothschil.design.factory.SteelFactory;
import io.github.rothschil.design.iterator.Aggregate;
import io.github.rothschil.design.iterator.ConcreteAggregate;
import io.github.rothschil.design.iterator.Iterator;
import io.github.rothschil.design.observer.Article;
import io.github.rothschil.design.observer.sync.Blogger;
import io.github.rothschil.design.observer.sync.Fans;
import io.github.rothschil.design.proxy.Access;
import io.github.rothschil.design.proxy.Accessible;
import io.github.rothschil.design.proxy.dynamic.CglibProxy;
import io.github.rothschil.design.proxy.stat.StaticProxy;
import io.github.rothschil.design.strategy.Cash;
import io.github.rothschil.design.strategy.Payment;
import io.github.rothschil.design.strategy.Shopping;
import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.proxy.Enhancer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("设计模式")
@Slf4j
public class TestDesign {

    @DisplayName("观察者模式")
    @Test
    public void testObserver() {
        Blogger blogger = new Blogger("Sam.Von.Abram");
        Fans fan1 = new Fans("张三");
        Fans fan2 = new Fans("李四");
        Fans fan3 = new Fans("朱元昌");
        blogger.addObserver(fan1);
        blogger.addObserver(fan2);
        blogger.addObserver(fan3);
        Article article1 = new Article("富豪","怎么成为富豪","");
        blogger.productArticle(blogger,article1);
    }

    @DisplayName("转换器模式")
    @Test
    public void testAdapter() {
        StandardAdapter adapter = new StandardAdapter();
        log.info("国标 {}",adapter.nationalStandard());
        log.warn("输出欧盟标准 {}",adapter.euStandards());
        log.warn("输出日本标准 {}",adapter.japaneseStandard());

    }

    @DisplayName("代理模式-静态代理")
    @Test
    public void testProxy2Static() {
        Access access = new StaticProxy(new Accessible());
        access.login();
    }

    @DisplayName("代理模式-动态代理-样例 1")
    @Test
    public void testProxy2DynamicDemo1() {
        CglibProxy proxy = new CglibProxy();
        Access access = (Access)proxy.getInstall(new Accessible());
        access.login();
    }

    @DisplayName("代理模式-动态代理-样例 2")
    @Test
    public void testProxy2DynamicDemo2() {
        CglibProxy proxy = new CglibProxy();
        // 自定义创建 Enhancer
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Accessible.class);
        enhancer.setCallback(proxy);
        Accessible access = (Accessible)enhancer.create();
        access.login();
    }

    @DisplayName("迭代器模式")
    @Test
    public void testIterator() {
        Aggregate ag = new ConcreteAggregate();
        ag.add("Java");
        ag.add("Python");
        ag.add("C++");
        ag.add("Visul Basic");
        Iterator it = ag.getIterator();
        while (it.hasNext()) {
            Object ob = it.next();
            log.warn(ob.toString() + "\t");
        }
        Object ob = it.first();
        log.warn("First：" + ob.toString());
    }

    @DisplayName("装饰器模式")
    @Test
    public void testDecorator() {
        Component cp = new ConcreteComponent();
        cp.say();
        log.warn("=====================");
        Component cpt = new ConcreteDecorator(cp);
        cpt.say();
    }

    @DisplayName("装饰器模式应用")
    @Test
    public void testDecoratorApp() {
        DmHunter hunter = new Original();
        hunter.display();

        DmHunter succubus = new Changer2Succubus(hunter);
        succubus.display();

        DmHunter girl = new Changer2Girl(hunter);
        girl.display();
    }

    @DisplayName("策略应用")
    @Test
    public void testStrategy() {
        Payment payment = new Cash();
        Shopping shopping = new Shopping(payment);
        shopping.buyDesktop();
    }

    @DisplayName("工厂模式")
    @Test
    public void testFactory(){
        SteelFactory steelFactory = new SteelFactory();
        Steel steel = steelFactory.getSteel(1);
        log.warn(steel.getClass().getSimpleName());
        steel.manufacturing(20);
    }


    @DisplayName("抽象工厂模式")
    @Test
    public void testAbstractFactory(){
        AbstractFactory abstractFactory1 = FactoryProducer.getAbstractFactory(1);
        Color color1  = abstractFactory1.getColor(1);
        color1.fill();
        Color color2  = abstractFactory1.getColor(2);
        color2.fill();

        int count =12;
        AbstractFactory abstractFactory2 = FactoryProducer.getAbstractFactory(2);
        Steel steel1 = abstractFactory2.getSteel(2);
        steel1.manufacturing(count);

        Steel steel2 = abstractFactory2.getSteel(1);
        steel2.manufacturing(count);
    }

    @DisplayName("创建者模式-1")
    @Test
    public void testBuilder1(){
        ChiefEngineer chiefEngineer = new ChiefEngineer();
        Car car = chiefEngineer.create(new ConcreteBuilder(new Car()));
        log.warn(car.toString());
    }

    @DisplayName("创建者模式-2")
    @Test
    public void testBuilder2(){
        ConcreteBuilder2 builder = new ConcreteBuilder2(new Car());
        builder.chassis().electrical().transmission().engine().tires();
        log.warn(builder.build().toString());
    }
}
