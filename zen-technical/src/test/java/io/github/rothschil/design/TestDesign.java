package io.github.rothschil.design;

<<<<<<< HEAD
import io.github.rothschil.design.adapter.StandardAdapter;
=======
import io.github.rothschil.design.abstractfactory.AbstractFactory;
import io.github.rothschil.design.abstractfactory.Color;
import io.github.rothschil.design.abstractfactory.FactoryProducer;
import io.github.rothschil.design.adapter.StandardAdapter;
import io.github.rothschil.design.builder.Car;
import io.github.rothschil.design.builder.model1.ChiefEngineer;
import io.github.rothschil.design.builder.model1.ConcreteBuilder;
import io.github.rothschil.design.builder.model2.ConcreteBuilder2;
>>>>>>> ea2ca0fad85ac3985e9e165d08f5038c79a932be
import io.github.rothschil.design.decorator.demo.Component;
import io.github.rothschil.design.decorator.demo.ConcreteComponent;
import io.github.rothschil.design.decorator.demo.ConcreteDecorator;
import io.github.rothschil.design.decorator.war3.Changer2Girl;
import io.github.rothschil.design.decorator.war3.Changer2Succubus;
import io.github.rothschil.design.decorator.war3.DmHunter;
import io.github.rothschil.design.decorator.war3.Original;
<<<<<<< HEAD
=======
import io.github.rothschil.design.factory.Steel;
import io.github.rothschil.design.factory.SteelFactory;
>>>>>>> ea2ca0fad85ac3985e9e165d08f5038c79a932be
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
<<<<<<< HEAD
import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.proxy.Enhancer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
=======
import io.github.rothschil.design.strategy.Cash;
import io.github.rothschil.design.strategy.Payment;
import io.github.rothschil.design.strategy.Shopping;
import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.proxy.Enhancer;
>>>>>>> ea2ca0fad85ac3985e9e165d08f5038c79a932be
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("????????????")
@Slf4j
public class TestDesign {

<<<<<<< HEAD
    long beginTime;
    long end;

    @BeforeEach
    public void before(){
        beginTime = System.currentTimeMillis();
    }

    @AfterEach
    public void after(){
        end = System.currentTimeMillis();
    }

    @AfterEach
    public void afterAll(){
        log.info("[AfterAll] ????????????={} ??????",(end-beginTime));
    }

=======
>>>>>>> ea2ca0fad85ac3985e9e165d08f5038c79a932be
    @DisplayName("???????????????")
    @Test
    public void testObserver() {
        Blogger blogger = new Blogger("Sam.Von.Abram");
        Fans fan1 = new Fans("??????");
        Fans fan2 = new Fans("??????");
        Fans fan3 = new Fans("?????????");
        blogger.addObserver(fan1);
        blogger.addObserver(fan2);
        blogger.addObserver(fan3);
        Article article1 = new Article("??????","??????????????????","");
        blogger.productArticle(blogger,article1);
    }

    @DisplayName("???????????????")
    @Test
    public void testAdapter() {
        StandardAdapter adapter = new StandardAdapter();
        log.info("?????? {}",adapter.nationalStandard());
        log.warn("?????????????????? {}",adapter.euStandards());
        log.warn("?????????????????? {}",adapter.japaneseStandard());

    }

    @DisplayName("????????????-????????????")
    @Test
    public void testProxy2Static() {
        Access access = new StaticProxy(new Accessible());
        access.login();
    }

    @DisplayName("????????????-????????????-?????? 1")
    @Test
    public void testProxy2DynamicDemo1() {
        CglibProxy proxy = new CglibProxy();
        Access access = (Access)proxy.getInstall(new Accessible());
        access.login();
    }

    @DisplayName("????????????-????????????-?????? 2")
    @Test
    public void testProxy2DynamicDemo2() {
        CglibProxy proxy = new CglibProxy();
        // ??????????????? Enhancer
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Accessible.class);
        enhancer.setCallback(proxy);
        Accessible access = (Accessible)enhancer.create();
        access.login();
    }

    @DisplayName("???????????????")
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
        log.warn("First???" + ob.toString());
    }

    @DisplayName("???????????????")
    @Test
    public void testDecorator() {
        Component cp = new ConcreteComponent();
        cp.say();
        log.warn("=====================");
        Component cpt = new ConcreteDecorator(cp);
        cpt.say();
    }

    @DisplayName("?????????????????????")
    @Test
    public void testDecoratorApp() {
        DmHunter hunter = new Original();
        hunter.display();

        DmHunter succubus = new Changer2Succubus(hunter);
        succubus.display();

        DmHunter girl = new Changer2Girl(hunter);
        girl.display();
    }
<<<<<<< HEAD
=======

    @DisplayName("????????????")
    @Test
    public void testStrategy() {
        Payment payment = new Cash();
        Shopping shopping = new Shopping(payment);
        shopping.buyDesktop();
    }

    @DisplayName("????????????")
    @Test
    public void testFactory(){
        SteelFactory steelFactory = new SteelFactory();
        Steel steel = steelFactory.getSteel(1);
        log.warn(steel.getClass().getSimpleName());
        steel.manufacturing(20);
    }


    @DisplayName("??????????????????")
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

    @DisplayName("???????????????-1")
    @Test
    public void testBuilder1(){
        ChiefEngineer chiefEngineer = new ChiefEngineer();
        Car car = chiefEngineer.create(new ConcreteBuilder(new Car()));
        log.warn(car.toString());
    }

    @DisplayName("???????????????-2")
    @Test
    public void testBuilder2(){
        ConcreteBuilder2 builder = new ConcreteBuilder2(new Car());
        builder.chassis().electrical().transmission().engine().tires();
        log.warn(builder.build().toString());
    }
>>>>>>> ea2ca0fad85ac3985e9e165d08f5038c79a932be
}
