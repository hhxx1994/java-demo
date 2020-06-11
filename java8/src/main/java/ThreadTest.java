/**
 * @author huanghaoxing
 */
public class ThreadTest {

    public static void main(String[] args)  {
        Thread thread = new Thread(() -> {
            System.out.println("thread");
            int i = 10 / 0;
        });


        thread.setUncaughtExceptionHandler((t, e) -> {
            e.printStackTrace();
        });
        thread.start();
       // thread.join();
        System.out.println("end");
        System.out.println(Thread.currentThread().getThreadGroup().activeCount());
    }
}
