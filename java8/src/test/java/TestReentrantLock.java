import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author hhx
 * 2017/11/7 22:18
 */
public class TestReentrantLock {
    @Test
    public void testLock() throws Exception {
        Resource resource = new Resource();
        Thread thread = new Thread(resource::produce);
        Thread thread2 = new Thread(resource::consume);
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread2.start();
        thread.join();
        thread2.join();
    }

    @Test
    public void testDoubleUnlock() throws Exception {
        Resource resource = new Resource();
        Thread thread = new Thread(resource::doubleUnlock);
        thread.start();
        thread.join();

    }

    class Resource {
        private Lock lock = new ReentrantLock();
        private Condition condition = lock.newCondition();

        public void doubleUnlock() {
            lock.lock();
            lock.lock();
            System.out.println("lock");
            lock.unlock();
            lock.unlock();
        }

        public void produce() {
            while (true) {
                try {
                    lock.tryLock(1, TimeUnit.SECONDS);
                    condition.signal();
                    System.out.println("produce");
                    TimeUnit.SECONDS.sleep(1);
                    condition.await();
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }

        public void consume() {
            while (true) {
                try {
                    lock.tryLock(1, TimeUnit.SECONDS);
                    System.out.println("consume");
                    TimeUnit.SECONDS.sleep(1);
                    condition.signal();
                    condition.await();
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }

        }
    }
}
