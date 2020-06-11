import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class MyTest {


    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(()->{
            System.out.println("start start");
            LockSupport.park(Thread.currentThread());
            System.out.println("start end");

        });
        t.start();
        TimeUnit.SECONDS.sleep(1);
        t.interrupt();

        t.join();

    }

}