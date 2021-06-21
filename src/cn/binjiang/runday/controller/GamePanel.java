package cn.binjiang.runday.controller;

import cn.binjiang.runday.view.GameFrame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * @author Cao Hengxiang
 */

public class GamePanel extends JPanel {
    Image background;
    public GamePanel(){
        try{
            background = ImageIO.read(new File("image/cc.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }
    //绘制方法
    int x = 0;
    @Override
    public void paint(Graphics g){
        super.paint(g);
        x--;
        g.drawImage(background,x,0,GameFrame.WIDTH,GameFrame.HEIGHT,null);
        g.drawImage(background,x + GameFrame.WIDTH,0,GameFrame.WIDTH,GameFrame.HEIGHT,null);

        if (x <= -GameFrame.WIDTH){
            x = 0;
        }
    }
    //运行程序的方法
    public void action() throws InterruptedException {
        while (true){
            Thread.sleep(1);
            //重绘方法
            //调用paint方法
            repaint();
        }
    }
}
