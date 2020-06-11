import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author huanghaoxing
 */
public class BlockQueue<T> {
    Object[] items;
    int addIndex, removeIndex, length;
    Lock lock;
    Condition notFull;
    Condition notEmpty;


    public BlockQueue(int size) {
        length = size - 1;
        items = new Object[size];
        lock = new ReentrantLock();
        notFull = lock.newCondition();

    }


    public void add(T t) throws Exception {
        lock.lock();
        try {
            while (length == addIndex) {
                notFull.await();
            }
            items[addIndex] = t;
            addIndex++;
            notEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }

}
