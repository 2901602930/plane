import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Vector;

public class GameFrame extends JFrame{

    MyPlane mp;
//    Bullets bt;
    Vector<Bullets> bt = new Vector<>();
    Vector<EenmyPlane> em = new Vector<>();

    public GameFrame(){
        //在窗体中创建我方飞机
        mp = new MyPlane();
        mp.start();
//        bt = new Bullets();
        //设置窗体的宽高
        this.setSize(475,750);
        this.setTitle("飞机大战");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        //画板线程
        //线程的创建https://blog.csdn.net/yangyechi/article/details/88079983
        new Thread(new Runnable() {
            @Override
            public void run() {

                while (true){

                    repaint();
//
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    // 在窗口上画, 内容. paint这个画笔的方法在窗口初始化的时候会默认的执行
    public void paint(Graphics g){
        System.out.println("huahua");
        //画背景
        BufferedImage image = (BufferedImage) this.createImage(this.getSize().width,this.getSize().height);
        //高速缓存的画笔
        Graphics bi = image.getGraphics();

        //画背景
        ImageIcon icon = new ImageIcon("C:\\Users\\86137\\Desktop\\java项目实训\\plane\\img\\bkg.png");
        bi.drawImage (icon.getImage(),0,0,null);

        //画我方飞机
        bi.drawImage (mp.icon.getImage(),mp.x,mp.y,mp.width,mp.height,null);

        //画我方子弹
       for (int i=0;i<bt.size();i++){
           bi.drawImage (bt.get(i).icon.getImage(),bt.get(i).x,bt.get(i).y,bt.get(i).width,bt.get(i).height,null);

       }
        //画敌机
        for (int i=0;i<em.size();i++){
            bi.drawImage (em.get(i).icon.getImage(),em.get(i).x,em.get(i).y,em.get(i).width,em.get(i).height,null);

        }


        //绘画生效
        g.drawImage(image,0,0,null);
    }


    public static void main(String[] args) {
        GameFrame frame = new GameFrame();
        frame.addKeyListener(new Player(frame));


    }




}

