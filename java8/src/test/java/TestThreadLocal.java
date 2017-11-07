import java.util.concurrent.TimeUnit;

/**
 * @author hhx
 * 2017/11/6 21:31
 */
public class TestThreadLocal {
    private static ThreadLocal<String> threadLocal=new ThreadLocal<>();
    class FirstThread extends Thread{

        @Override
        public void run() {
            threadLocal.set("first thread");
            threadLocal.get();

        }
    }
    class SecondThread extends Thread{
        @Override
        public void run() {
           threadLocal.set("Second thread");

        }
    }


    public static void main(String[] args)throws Exception {
        TestThreadLocal testThreadLocal = new TestThreadLocal();
        testThreadLocal.new FirstThread().start();
        testThreadLocal.new SecondThread().start();
        while(true) {
            TimeUnit.SECONDS.sleep(1);

        }
    }

}
