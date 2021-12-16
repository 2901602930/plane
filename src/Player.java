import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Player implements KeyListener {

//    MyPlane mp;
//    Bullets bt;
//    public Player(MyPlane mp,Bullets bt) {
//        this.bt = bt;
//        this.mp = mp;
//    }
    Random rand = new Random();
    GameFrame gf;
    int i=0;
    int j = 0;
    public Player(GameFrame gf) {
        this.gf = gf;
    }

    //上：38 下：40 左：37 右：39
    @Override // 按下
    public void keyPressed(KeyEvent e) {
//            System.out.printf("按下："+KeyEvent.getKeyText(e.getKeyCode()) + "\n");
        System.out.printf("按下：" + e.getKeyCode() + "\n");
        //上：38 下：40 左：37 右：39
        switch (e.getKeyCode()){
            case 38:
                gf.mp.up = true;
                break;
            case 37:
                gf.mp.left = true;
                break;
            case 39:
                gf.mp.right = true;
                break;
            case 40:
                gf.mp.down = true;
                break;
            case 68:
                //创建一个子弹
                System.out.print(i);
                gf.bt.add(new Bullets(gf.mp.x+15,gf.mp.y-50));
                gf.bt.get(i).boom = true;
                gf.bt.get(i).start();
                i++;
                break;
            case 10:
                //产生敌机
                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        while (true){
                            System.out.println("敌机");
                            gf.em.add(new EenmyPlane(rand.nextInt(450)+50,0));
                            gf.em.get(j).chong = true;
                            gf.em.get(j).start();
                            j++;
//
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();

        }
    }
    @Override // 松开
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()){
            case 38:
                gf.mp.up = false;
                break;
            case 37:
                gf.mp.left = false;
                break;
            case 39:
                gf.mp.right = false;
                break;
            case 40:
                gf.mp.down = false;
                break;
        }
    }
    @Override // 输入的内容
    public void keyTyped(KeyEvent e) {
//            System.out.printf("输入：" + e.getKeyChar() + "\n");
    }



}
