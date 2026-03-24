package com.fiveplusone.ui;

import javax.swing.*;

public class GameJFrame extends JFrame {
    public GameJFrame() {
        this.setSize(603, 680);
        this.setTitle("拼图 v1.0");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        //设置关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
