import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author hhx
 * 2017/11/7 22:03
 */
public class TestSynchronizedWaitNotify {

    class Resource{
        public  void produce(){
            while(true){
                synchronized (this) {
                    notify();
                    System.out.println("produce");
                    try {
                        wait();
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        public  void consume(){
            while(true){
                synchronized (this){
                    System.out.println("consume");
                    notify();
                    try {
                        wait();
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    @Test
    public void testSynchronizedWaitNotify() throws Exception{
        Resource resource = new Resource();
        Thread thread = new Thread(resource::produce);
        Thread thread2 = new Thread(resource::consume);
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread2.start();
        thread.join();
        thread2.join();
    }
}
