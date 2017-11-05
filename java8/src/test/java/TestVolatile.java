import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author hhx
 *
 */
public class TestVolatile {

    @Test
    public void testVolatile() throws Exception{
        MyRunnable myRunnable=new MyRunnable();
        new Thread(myRunnable).start();
        Thread.sleep(3000);
        myRunnable.cancel();
    }

    class MyRunnable implements Runnable{
        private boolean cancle;
        @Override
        public void run() {
            while(!cancle){
                System.out.println("Running ....");
            }
        }
        public void cancel(){
            cancle=true;
        }
    }


    class NoVolatileThread extends Thread {
        private volatile boolean canceled;
        private void cancel(){
            canceled =true;
        }
        @Override
        public void run() {
            while (!canceled){
                //doSomeThings
            }
        }
    }

    public static void main(String[] args) throws Exception{
        NoVolatileThread noVolatileThread = new TestVolatile().new NoVolatileThread();
        noVolatileThread.start();
        TimeUnit.SECONDS.sleep(3);
        noVolatileThread.cancel();
        System.out.println("cancel");
    }

}
