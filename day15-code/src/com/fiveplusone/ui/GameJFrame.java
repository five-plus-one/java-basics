package com.fiveplusone.ui;

import javax.swing.*;

public class GameJFrame extends JFrame {
    public GameJFrame() {
        initJFrame();
        initJMenuBar();
        initImage();



        //展示界面
        this.setVisible(true);
    }

    private void initImage() {
        //初始化图片
        ImageIcon icon = new ImageIcon("D:\\5plus1\\Study\\College\\java\\java_basics\\basic-code\\day15-code\\image\\animal\\animal3\\1.jpg");

        JLabel jLabel = new JLabel(icon);
        jLabel.setBounds(0,0,105,105);

        this.getContentPane().add(jLabel);
    }

    private void initJMenuBar() {
        //初始化菜单
        //创建菜单对象
        JMenuBar jMenuBar = new JMenuBar();

        JMenu functionJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("关于我们");

        //创建选项下面的条目
        JMenuItem replayItem = new JMenuItem("重新游戏");
        JMenuItem reLoginItem = new JMenuItem("重新登录");
        JMenuItem closeItem = new JMenuItem("关闭游戏");

        JMenuItem accountItem = new JMenuItem("公众号");

        //将每一个选项下面的条目添加到选项中
        functionJMenu.add(replayItem);
        functionJMenu.add(reLoginItem);
        functionJMenu.add(closeItem);

        aboutJMenu.add(accountItem);

        //添加到菜单中
        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutJMenu);


        this.setJMenuBar(jMenuBar);
    }

    private void initJFrame() {
        this.setSize(603, 680);
        this.setTitle("拼图 v1.0");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        //设置关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //取消默认的居中放置
        this.setLayout(null);
    }
}
