import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author hhx
 * 2017/11/8 23:11
 */
public class TestReadWriteLock {
    @Test
    public void testReadLock() {
        Resource resource = new Resource();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> resource.read(() -> {
                for(int j=0;j<10;j++){
                    System.out.println(j);
                    try {
                        TimeUnit.MILLISECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            })).start();
        }
        while (true) {

        }
    }
    @Test
    public void testWriteLock(){

    }

    class Resource {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

        public void read(Execution execution) {
            try {
                lock.readLock().lock();
                execution.execute();
            } finally {
                lock.readLock().unlock();
            }
        }
    }
}
