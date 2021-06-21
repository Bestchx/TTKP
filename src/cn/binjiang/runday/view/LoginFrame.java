package cn.binjiang.runday.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * @author CaoHengxiang
 * 登陆界面:背景图片,用户名输入框,密码输入框,登录按钮,取消按钮
 */

public class LoginFrame extends JFrame{
    //用户名 用户密码
    JLabel userName;
    JLabel passwordName;
    JTextField userTest;
    JPasswordField userPassword;
    JButton Login;
    JButton Cancle;

    public LoginFrame(){
        //用户名
        userName =new JLabel("用户名");
        userName.setBounds(10,140,60,30);
        this.add(userName);

        userTest = new JTextField();
        userTest.setBounds(70,142,140,25);
        userTest.setBorder(BorderFactory.createLoweredBevelBorder());
        //设置输入框背景透明
        userTest.setOpaque(false);
        this.add(userTest);

        //用户密码
        passwordName = new JLabel("用户密码");
        passwordName.setBounds(10,170,60,30);
        this.add(passwordName);

        userPassword = new JPasswordField();
        userPassword.setBounds(70,172,140,25);
        userPassword.setBorder((BorderFactory.createLoweredBevelBorder()));
        //设置背景框透明
        userPassword.setOpaque(false);
        this.add(userPassword);

        //登录按钮
        Login = new JButton("登录");
        Login.setBounds(60,240,60,25);
        Login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //获取用户名输入框和密码数据库的内容
                String username = userTest.getText();
                String password = userPassword.getText();
                if("小熊困呼呼".equals(username) && "123".equals(password)){
                    //登陆成功
                    JOptionPane.showMessageDialog(null,"登陆成功");
                    //关闭当前界面
                    dispose();
                    //调转到下一界面
                    new MemuFrame();
                } else{
                    //登陆失败
                    JOptionPane.showMessageDialog(null,"用户名和密码错误!");
                }

            }
        });

        this.add(Login);


        //取消按钮
        Cancle = new JButton("注销");
        Cancle.setBounds(150,240,60,25);
        this.add(Cancle);
        Cancle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //监听事件的方法,点击取消按钮的时候,执行的是该方法的内容
                JOptionPane.showMessageDialog(null,"确定离开");
                //关闭窗体
                dispose();
            }
        });

        //创建面板对象并添加到窗体上去
        LoginBack back = new LoginBack();
        this.add(back);
        //设置窗体的基本属性
        this.setSize(599,330);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setUndecorated(true);
        //设置LOGO图片
        this.setIconImage(new ImageIcon("image//115.png").getImage());


        this.setVisible(true);

    }
    public static void main(String[] args) {
        new LoginFrame();
    }
    //登录界面的面板类
    class LoginBack extends JPanel{
        //背景图片变量
        Image background;
        public LoginBack(){
            try {
                background = ImageIO.read(new File("image/login.jpg"));
            } catch (IOException e) {
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




















