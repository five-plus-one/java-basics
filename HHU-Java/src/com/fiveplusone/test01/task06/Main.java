package com.fiveplusone.test01.task06;

// 1. 定义点类 Point
class Point {
    private double x; // 横坐标
    private double y; // 纵坐标

    // 构造函数
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // 获取横坐标的方法
    public double GetX() {
        return x;
    }

    // 获取纵坐标的方法
    public double GetY() {
        return y;
    }
}

// 2. 定义线段类 Line
class Line {
    private Point p1; // 端点1
    private Point p2; // 端点2

    // 构造函数：接收两个 Point 对象
    public Line(Point p1, Point p2) {
        // 根据需求：“在构造函数中通过创建新的Point对象来初始化端点”
        // 这种做法被称为深拷贝，增强了类的封装性和安全性
        this.p1 = new Point(p1.GetX(), p1.GetY());
        this.p2 = new Point(p2.GetX(), p2.GetY());
    }

    // 计算线段长度的方法
    public double Length() {
        // 使用两点间距离公式：√((x1 - x2)² + (y1 - y2)²)
        double dx = p1.GetX() - p2.GetX();
        double dy = p1.GetY() - p2.GetY();
        // Math.sqrt() 用于计算平方根
        return Math.sqrt(dx * dx + dy * dy);
    }
}

// 3. 主运行类
public class Main {
    public static void main(String[] args) {
        // 创建两个 Point 对象，分别传入坐标 (0,0) 和 (3,4)
        Point pointA = new Point(0, 0);
        Point pointB = new Point(3, 4);

        // 用这两个点构造 Line 对象
        Line line = new Line(pointA, pointB);

        // 调用 Length() 方法输出线段长度
        double length = line.Length();
        System.out.println("端点1坐标: (" + pointA.GetX() + ", " + pointA.GetY() + ")");
        System.out.println("端点2坐标: (" + pointB.GetX() + ", " + pointB.GetY() + ")");
        System.out.println("线段长度 = " + length);
    }
}