import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author hhx
 * 2017/11/8 21:07
 */
public class LockUtils {
    private static  final Lock LOCK=new ReentrantLock();
    private static Map<String,CountLock> lockMap=new HashMap<>(16);
    private LockUtils(){}
    public static void lock(String key, Execution execution){
        Lock lock = getLock(key);
        try {
            lock.lock();
            execution.execute();
        }finally {
            lock.unlock();
            removeLock(key);
        }
    }

    public static Lock getLock(String key) {
        CountLock countLock;
        Lock lock;
        try {
            LOCK.lock();
            countLock = lockMap.get(key);
            if(countLock == null){
                lock = new ReentrantLock();
                countLock = new CountLock(lock);
                lockMap.put(key, countLock);
            }else {
                lock=countLock.getLock();
            }
            countLock.countIncrease();
        }finally {
            LOCK.unlock();
        }
        return lock;
    }

    public static void removeLock(String key){
        try {
            LOCK.lock();
            CountLock countLock = lockMap.get(key);
            if(countLock.decreaseAndGet() == 0){
                lockMap.remove(key);
            }
        }finally {
            LOCK.unlock();
        }
    }

    static class CountLock{
        private Lock lock;
        private int count;

        public CountLock() {
        }

        public CountLock(Lock lock) {
            this.lock = lock;
        }

        public Lock getLock() {
            return lock;
        }

        public void setLock(Lock lock) {
            this.lock = lock;
        }
        public void countIncrease(){
            count++;
        }
        public int decreaseAndGet(){
            return --count;
        }

    }

}
