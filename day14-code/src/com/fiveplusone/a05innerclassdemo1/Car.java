package com.fiveplusone.a05innerclassdemo1;

public class Car {
    String carName;
    int carAge;
    String carColor;

    public void show(){
        System.out.println(carName);
//        System.out.println(engineName);
        Engine e = new Engine();
        System.out.println(e.engineName);
    }
    class Engine{
        String engineName;
        int engineAge;
        public void show(){
            System.out.println(engineName);
            System.out.println(carName);
        }
    }
}
