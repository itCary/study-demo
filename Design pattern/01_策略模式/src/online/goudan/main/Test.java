package online.goudan.main;

import online.goudan.behavior.impl.GaGaQuackBehavior;
import online.goudan.behavior.impl.GoodFlyBehavior;
import online.goudan.duck.Duck;
import online.goudan.duck.GreenHeadDuck;


public class Test {
    public static void main(String[] args) {
        Duck duck = new GreenHeadDuck();
        duck.setFlyBehavior(new GoodFlyBehavior());
        duck.setQuackBehavior(new GaGaQuackBehavior());
        duck.display();
        duck.fly();
        duck.quack();
    }

}
