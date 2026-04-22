package com.fiveplusone.homework06.task02;

// 1. 自定义必检异常
class WeatherException extends Exception {
    public WeatherException(String message) {
        super(message);
    }
}

// 2.调度员类
class FlightDispatcher {
    public void checkWeather(int visibility) throws WeatherException {
        if (visibility < 500) {
            throw new WeatherException("当前能见度为 " + visibility + " 米，低于最低起飞标准（500米）");
        }
        System.out.println("当前能见度为 " + visibility + " 米，符合起飞标准");
    }
}

// 3.塔台类
class Tower {
    private FlightDispatcher dispatcher = new FlightDispatcher();

    public void authorizeTakeoff(int visibility) throws WeatherException {
        System.out.println("塔台：正在向调度员请求核实...");
        dispatcher.checkWeather(visibility);
        System.out.println("塔台：核实通过，允许飞行");
    }
}

// 4.主程序
public class AviationSystem {
    public static void main(String[] args) {
        Tower tower = new Tower();

        System.out.println("1号航班请求起飞...");
        try{
            tower.authorizeTakeoff(800);
        }catch (WeatherException e){
            System.err.println("错误：起飞终止，" + e.getMessage());
        }

        System.out.println("------");

        System.out.println("2号航班请求起飞...");
        try{
            tower.authorizeTakeoff(450);
        }catch (WeatherException e){
            System.err.println("错误：起飞终止，" + e.getMessage());
        }
    }
}
