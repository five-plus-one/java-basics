package com.fiveplusone.test01;

// 1. 定义二维图形标准接口
interface ShapeStandard {
    // 接口中的变量默认是 public static final 的
    double PI = 3.14;

    // 计算面积的抽象方法
    double calculateArea();
}

// 2. 定义调色板接口
interface Palette {
    // 填充颜色的抽象方法
    void applyColor(String colorName);
}

// 3. 定义具体的图形类：圆形图案类
// 在 Java 中，一个类可以同时实现多个接口，以此来扩展多种能力
class CirclePattern implements ShapeStandard, Palette {
    private double radius; // 图案半径
    private String color;  // 图案颜色

    // 构造方法，用于初始化半径
    public CirclePattern(double radius) {
        this.radius = radius;
    }

    // 实现 ShapeStandard 接口的方法
    @Override
    public double calculateArea() {
        // 圆的面积公式：PI * r * r
        return PI * radius * radius;
    }

    // 实现 Palette 接口的方法
    @Override
    public void applyColor(String colorName) {
        this.color = colorName; // 更新图案颜色属性
        System.out.println("当前填充颜色 = " + this.color);
    }

    // 提供 Getter 和 Setter 方法是一种良好的封装习惯（可选）
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }
}

// 4. 定义主运行类
public class DrawingBoard {
    public static void main(String[] args) {
        // 创建一个 CirclePattern 对象，设定初始半径为 2.0
        CirclePattern circle = new CirclePattern(2.0);

        // 调用上色方法，将图形填充为蓝色
        circle.applyColor("blue");

        // 调用面积计算方法并输出
        double area = circle.calculateArea();
        System.out.println("图形面积 = " + area);
    }
}