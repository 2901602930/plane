
import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class MyPlane extends Thread {

    Vector<Bullets> bt = new Vector<>();
    Vector<EenmyPlane> em = new Vector<>();
    int x = 200, y = 650;
    int width = 50, height = 50;
    boolean left, right, up, down = false;

    ImageIcon icon = new ImageIcon("C:\\Users\\86137\\Desktop\\java项目实训\\plane\\img\\myplane.png");
    Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (obj) {
                if (up == true) {
                    y = y - 10;
                }

                if (down == true) {
                    y = y + 10;
                }


                if (left == true) {
                    x = x - 10;
                }

                if (right == true) {
                    x = x + 10;
                }
                /**
                 * 返回物体对应矩形区域，便于后续在碰撞检测中使用
                 * @return
                 */
                Rectangle diji = new Rectangle(em.get(0).x, em.get(0).y, em.get(0).width, em.get(0).height);
                Rectangle zidan = new Rectangle(bt.get(0).x, bt.get(0).y, bt.get(0).width, bt.get(0).height);
                boolean hit = false;
                hit = zidan.intersects(diji);
                if (hit==true){
                    System.out.print("hit");
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}


