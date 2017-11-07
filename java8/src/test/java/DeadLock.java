import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author haoxing_h
 */
public class DeadLock {
    private Object left=new Object();
    private Object right=new Object();

    public void leftRigth(){
        synchronized (left){
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (right){
                System.out.println("coming leftRight");
            }
        }
    }

    public void rightLeft(){
        synchronized (right){
            synchronized (left){
                System.out.println("coming rightLeft");
            }
        }
    }

    public static void main(String[] args)throws Exception {
        DeadLock deadLock = new DeadLock();
        new Thread(()->{
            deadLock.leftRigth();
        }).start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(()->{
            deadLock.rightLeft();
        }).start();
    }

}
