package cn.binjiang.runday.view;

import javax.swing.*;
import java.awt.*;

/**
 * @author Cao Hengxiang
 * 缓冲加载界面:进度条,自动加载功能
 */

public class WindowFrame extends JFrame implements Runnable{
    JLabel image;
    //进度条
    JProgressBar jdt;

    //创建线程的方法
    public void Start(){
        //创建一个线程,并绑定当前窗体
        Thread t = new Thread(this);
        //启动线程
        t.start();
    }

    public WindowFrame(){
        image = new JLabel(new ImageIcon("image//hbg.jpg"));
        this.add(BorderLayout.NORTH,image);

        jdt = new JProgressBar();
        //以字符串的形式显示进度条
        jdt.setStringPainted(true);
        jdt.setBackground(Color.PINK);
        this.add(BorderLayout.SOUTH,jdt);

        this.setSize(568,340);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setUndecorated(true);
        //设置LOGO图片
        this.setIconImage(new ImageIcon("image//115.png").getImage());

        this.setVisible(true);
    }
    public static void main(String[] args) {
        new WindowFrame().Start();
    }

    @Override
    public void run() {
        //进度条加载的数据
        int [] values = {0,1,2,3,4,5,6,7,8,9,10,10,10,10,10,10,10,10,10,70,80,90,91,92,93,94,95,95,95,95,95,95,95,96,96,96,97,97,97,97,98,98,99,99,100};
        for (int i = 0;i < values.length;i++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }//线程休眠
            jdt.setValue(values[i]);
        }
        //关闭当前界面
        dispose();
    }
}
