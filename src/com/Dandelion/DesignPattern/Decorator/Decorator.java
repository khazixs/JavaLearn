package com.Dandelion.Designpattern.Decorator;

public class Decorator {
    public static void main(String[] args) {
        Car myCar = new Car();
        FlyCar fc = new FlyCar(myCar);
        WaterCar wc = new WaterCar(fc);
        wc.move();
        AutoCar ac = new AutoCar(fc);
        ac.move();
    }
}

interface ICar {
    void move();
}

//真是对象，被装饰对象，具体对象ConcreteComponent
class Car implements ICar {
    @Override
    public void move() {
        System.out.println("在陆地上跑！");
    }
}

class SuperCar implements ICar {
    protected ICar car;

    SuperCar(ICar car) {
        this.car = car;
    }

    @Override
    public void move() {
        car.move();
    }
}

class FlyCar extends SuperCar {
    FlyCar(ICar car) {
        super(car);
    }

    private void fly() {
        System.out.println("天上飞！");
    }

    @Override
    public void move() {
        super.move();
        fly();
    }
}

class WaterCar extends SuperCar {
    WaterCar(ICar car) {
        super(car);
    }

    private void swim() {
        System.out.println("水中游！");
    }

    @Override
    public void move() {
        super.move();
        swim();
    }
}

class AutoCar extends SuperCar {
    AutoCar(ICar car) {
        super(car);
    }

    public void auto() {
        System.out.println("自动跑！");
    }

    @Override
    public void move() {
        super.move();
        auto();
    }
}