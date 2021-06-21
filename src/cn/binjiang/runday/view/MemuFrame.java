package cn.binjiang.runday.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

/**
 * @author Cao Hengxiang
 * 菜单选择界面:开始游戏,帮助,退出
 */

public class MemuFrame extends JFrame implements MouseListener {
    //开始 帮助 退出
    JLabel start,help,exit;

    public MemuFrame(){
        start = new JLabel(new ImageIcon("image//hh1.png"));
        start.setBounds(220,390,150,40);
        start.setEnabled(false);
        start.addMouseListener(this);
        this.add(start);
        help = new JLabel(new ImageIcon("image//hh2.png"));
        help.setBounds(900,70,150,40);
        help.setEnabled(false);
        help.addMouseListener(this);
        this.add(help);
        exit = new JLabel(new ImageIcon("image//hh3.png"));
        exit.setBounds(450,390,150,40);
        exit.setEnabled(false);
        exit.addMouseListener(this);
        this.add(exit);


        //创建面板对象并添加到窗体上去
        MemuBack back = new MemuBack();
        this.add(back);
        //设置窗体的基本属性
        this.setSize(1136,640);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("小熊爱跑酷");
        this.setUndecorated(false);
        //设置LOGO图片
        this.setIconImage(new ImageIcon("image//115.png").getImage());

        this.setVisible(true);
    }
    public static void main(String[] args) {
        new MemuFrame();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //点击鼠标执行的方法
        if (e.getSource().equals(start)){
            //关闭当前界面
            dispose();
            //调转到下一界面
        }
        if (e.getSource().equals(exit)){
            //退出
            System.exit(0);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //鼠标移入
        if (e.getSource().equals(start)){
            start.setEnabled(true);
        }
        if (e.getSource().equals(help)){
            help.setEnabled(true);
        }
        if (e.getSource().equals(exit)){
            exit.setEnabled(true);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //鼠标移出
        if(e.getSource().equals(start)){
            start.setEnabled(false);
        }
        if(e.getSource().equals(help)){
            help.setEnabled(false);
        }
        if(e.getSource().equals(exit)){
            exit.setEnabled(false);
        }
    }

    //菜单界面的面板类
    class MemuBack extends JPanel{
        Image background;
        public MemuBack(){
            try{
                background = ImageIO.read(new File("image//main.png"));
            } catch (IOException e){
                e.printStackTrace();
            }
        }

        //绘制方法
        @Override//画笔类型,一支画笔
        public void paint(Graphics g){
            g.drawImage(background,0,0,null);
        }
    }
}
