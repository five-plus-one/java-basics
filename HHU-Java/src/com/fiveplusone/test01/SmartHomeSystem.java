package com.fiveplusone.test01;

// 1. 定义基类 SmartDevice (智能设备)
class SmartDevice {
    // 定义属性：安装位置
    protected String location;

    // 构造方法初始化属性
    public SmartDevice(String location) {
        this.location = location;
    }

    // 通用的工作方法
    public void work() {
        System.out.println("【系统提示】位于 [" + location + "] 的智能设备已通电并启动。");
    }
}

// 2. 定义子类 CleaningRobot (扫地机器人)
class CleaningRobot extends SmartDevice {

    // 调用父类构造方法
    public CleaningRobot(String location) {
        super(location);
    }

    // 重写 work() 方法
    @Override
    public void work() {
        System.out.println("🤖 位于 [" + location + "] 的扫地机器人已启动，正在自动规划路线并清扫地面...");
    }
}

// 3. 定义子类 AirPurifier (空气净化器)
class AirPurifier extends SmartDevice {

    // 调用父类构造方法
    public AirPurifier(String location) {
        super(location);
    }

    // 重写 work() 方法
    @Override
    public void work() {
        System.out.println("🍃 位于 [" + location + "] 的空气净化器已启动，正在检测空气质量并进行净化...");
    }
}

// 4. 定义主运行类 SmartHomeSystem
public class SmartHomeSystem {
    public static void main(String[] args) {

        System.out.println("====== 智能家居控制系统正在初始化 ======\n");

        // 步骤 A: 创建一个 SmartDevice 数组，长度设定为 4 (满足至少为3的要求)
        SmartDevice[] devices = new SmartDevice[4];

        // 步骤 B: 创建不同位置的具体设备对象，向上转型为 SmartDevice 并存入数组
        devices[0] = new CleaningRobot("客厅");
        devices[1] = new AirPurifier("主卧");
        devices[2] = new CleaningRobot("走廊");
        devices[3] = new AirPurifier("书房");

        // 步骤 C: 使用增强型 for 循环（或普通 for 循环）遍历数组
        System.out.println("====== 一键启动所有智能设备 ======");
        for (SmartDevice device : devices) {
            // 依次调用每个元素的 work() 方法
            // 此时会触发Java的多态机制，根据实际子类对象调用被重写的方法
            device.work();
        }

        System.out.println("\n====== 系统指令执行完毕 ======");
    }
}