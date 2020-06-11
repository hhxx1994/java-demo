import java.util.concurrent.locks.ReentrantLock;

/**
 * @author hhx
 * 2017/11/8 21:07
 */
public class LockUtils {

    static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws Exception {

        try {
            lock.lock();
            Thread thread = new Thread(() -> {
                try {
                    lock.lock();
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().isInterrupted());
                lock.unlock();
                System.out.println("aa");
            });
            thread.start();
            while (true) {
                Thread.sleep(101);
                thread.interrupt();
            }
        } finally {
            lock.unlock();
        }

    }

}
