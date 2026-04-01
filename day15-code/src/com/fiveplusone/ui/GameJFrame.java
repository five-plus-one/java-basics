package com.fiveplusone.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener {

    int[][] data = new int[4][4];
    int x = 0, y = 0;

    public GameJFrame() {
        // 初始化界面
        initJFrame();

        // 初始化菜单
        initJMenuBar();

        //初始化数据（打乱）
        initData();

        //初始化图片
        initImage();


        //展示界面
        this.setVisible(true);
    }

    private void initData() {
        int[] tempArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

        Random r = new Random();
        for (int i = 0; i < tempArr.length; i++) {
            int index = r.nextInt(tempArr.length);
            int temp = tempArr[i];
            tempArr[i] = tempArr[index];
            tempArr[index] = temp;
        }

        for (int i = 0; i < tempArr.length; i++) {
            if (tempArr[i] == 0) {
                x = i / 4;
                y = i % 4;
            }
            data[i / 4][i % 4] = tempArr[i];
        }
    }

    private void initImage() {
        this.getContentPane().removeAll();
        //初始化图片
        //先加载的图片在上方，后加载的在下方
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int num = data[i][j];
                JLabel jLabel = new JLabel(new ImageIcon("day15-code/image/animal/animal3/" + num + ".jpg"));
                jLabel.setBounds(105 * j + 83, 105 * i + 134, 105, 105);
                jLabel.setBorder(new BevelBorder(BevelBorder.LOWERED));
                this.getContentPane().add(jLabel);
            }
        }
        JLabel background = new JLabel(new ImageIcon("day15-code/image/background.png"));
        background.setBounds(40, 40, 508, 560);
        this.getContentPane().add(background);
        this.getContentPane().repaint();

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

        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == 37) {
            picMoveFrom(0,1);
            System.out.println("向左移动");
        } else if (code == 38) {
            picMoveFrom(1,0);
            System.out.println("向上移动");
        } else if (code == 39) {
            picMoveFrom(0,-1);
            System.out.println("向右移动");
        } else if (code == 40) {
            picMoveFrom(-1,0);
            System.out.println("向下移动");
        }
    }

    private void picMoveFrom(int x, int y) {
        int oldX = x + this.x;
        int oldY = y + this.y;
        if(oldX >= 0 && oldX < 4 && oldY >= 0 && oldY < 4) {
            data[this.x][this.y] = data[oldX][oldY];
            data[oldX][oldY] = 0;
            this.x = oldX;
            this.y = oldY;
            initImage();
        }
    }
}
