import org.junit.Test;

/**
 * @author hhx
 * @date 2017/11/5 9:41
 * @description
 */
public class TestVolatile {

    @Test
    public void testVolatilt() throws Exception{
        MyRunnable myRunnable=new MyRunnable();
        new Thread(myRunnable).start();
        Thread.sleep(3000);
        myRunnable.cancle();
    }

    class MyRunnable implements Runnable{
        private boolean cancle;
        @Override
        public void run() {
            while(!cancle){
                System.out.println("Running ....");
            }
        }
        public void cancle(){
            cancle=true;
        }
    }


}
