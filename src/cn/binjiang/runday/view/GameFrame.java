package cn.binjiang.runday.view;

import cn.binjiang.runday.controller.GamePanel;

import javax.swing.*;

/**
 * @author Cao Hengxiang
 */


public class GameFrame extends JFrame {
    //设置窗体宽高属性
    public static final int WIDTH=1000;
    public static final int HEIGHT=600;
    public GameFrame() throws InterruptedException {
        //2.4创建游戏面板对象，并添加到窗体上去
        GamePanel panel = new GamePanel();


        this.add(panel);

        /**1.设置窗体基本属性*/
        this.setSize(WIDTH,HEIGHT);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(new ImageIcon("Image/115.png").getImage());
        this.setUndecorated(true);
        this.setVisible(true);
        panel.action();//程序启动的方法
    }

    public static void main(String[] args) throws InterruptedException {
        new GameFrame();
    }
}