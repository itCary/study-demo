package online.goudan.duck;

import online.goudan.behavior.FlyBehavior;
import online.goudan.behavior.QuackBehavior;

public abstract class Duck {
    FlyBehavior mFlyBehavior;
    QuackBehavior mQuackBehavior;

    public Duck() {

    }

    public void fly() {
        mFlyBehavior.fly();
    }

    public void quack() {
        mQuackBehavior.quack();
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.mFlyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.mQuackBehavior = quackBehavior;
    }

    public abstract void display();
}
