package cn.binjiang.runday.model;

import cn.binjiang.runday.view.GameFrame;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Person {//1.声明属性
    Image image;//1.1 玩家当前显示图片
    Image[] images;//1.2 玩家所有图片

    public static final int WIDTH = 90;//1.3玩家宽高
    public static final int HEIGHT = 60;

    //1.4玩家初始位置坐标
    int x,y;
    int index;//下面用作切换图片
    //玩家得分
    int score;
    //玩家跑酷距离
    int distance;
    //玩家生命
    int life;

    public Person() throws IOException {//2.赋值
        images = new Image[9];
        for (int i = 0;i < images.length;i++){
            try{
                images[i] = ImageIO.read(new File("image/1.png"));
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        //给图片数组images赋值
        init();//2.1  先写，会提示要不要实现！自动生成方法
        //默认当前显示图片位第一张图片 2.6
        image = images[0];

        x = 200;//2.7
        y = 350;//脚踩地板
        index = 0;
        score = 0;
        distance = 0;
        life = 3;
    }
    //玩家自由下落方法5.1
    public void drop() {
        y += 5;
        if(y>=580){// 下落归下落，也得温柔点，不能让小人儿踩破了地板
            y = 580;
        }
    }
    //玩家移动的方法
    public void step(){
        //玩家图片的切换
        image = images[index ++ /90 %images.length];
        //玩家坐标改变（玩家坐标通过键盘控制，此次不做处理）
    }
    //绘制玩家的方法
    public void paintPerson(Graphics g){
        g.drawImage(image, x, y, WIDTH, HEIGHT, null);
    }

    //判断玩家是否越界的方法
    public boolean isOutOfBounds(){
        return this.x >= GameFrame.WIDTH || this.x <= -WIDTH;
    }
    private void init() {//2.2
        images = new Image[9];
        for(int i = 0; i<images.length; i++){//2.3
            try {//2.5
                images[i] = ImageIO.read(new File("Image/"+(i+1) + ".png"));//2.4
            } catch (IOException e) {//2.5
                e.printStackTrace();
            }
        }
    }
    //2.8  右键，Source，GGAS
    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Image[] getImages() {
        return images;
    }

    public void setImages(Image[] images) {
        this.images = images;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public static int getWidth() {
        return WIDTH;
    }

    public static int getHeight() {
        return HEIGHT;
    }
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public int getDistance() {
        return distance;
    }
    public void setDistance(int distance) {
        this.distance = distance;
    }

}