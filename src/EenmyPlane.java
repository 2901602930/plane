import javax.swing.*;
import java.util.Random;

public class EenmyPlane extends Thread{

    Random rd = new Random();
    int x,y;
    int width = 100, height = 100;
    boolean chong = false;

    ImageIcon icon = new ImageIcon("C:\\Users\\86137\\Desktop\\java项目实训\\plane\\img\\enemyPlane.png");

    public EenmyPlane(int x, int y) {
        this.x = x;
        this.y = y;
    }

    Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (obj) {
                if (chong == true) {
                    y = y + rd.nextInt(8)+2;
                }
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


}
