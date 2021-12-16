import javax.swing.*;

public class Bullets extends Thread{
    int x,y;
    int width = 20, height = 50;
    boolean boom = false;

    ImageIcon icon = new ImageIcon("C:\\Users\\86137\\Desktop\\java项目实训\\plane\\img\\bullet.png");

    public Bullets(int x, int y) {
        this.x = x;
        this.y = y;
    }

    Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (obj) {
                if (boom == true) {
                    y = y - 10;
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
