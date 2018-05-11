import org.junit.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import static java.lang.Thread.sleep;

public class DebugLock {

    private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    private ReentrantLock lock;

    @Test
    public void debugLock() {
        lock = new ReentrantLock();
        new Thread(() -> {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.lock();
            System.out.println("lock");
            lock.unlock();
        }).start();

        new Thread(() -> {
            lock.lock();
            System.out.println("lock2");
            lock.unlock();
        }).start();

        System.out.println();

    }

    @Test
    public void rwLock() {

        //wwLock();
        rrLock();
        System.out.println();

    }

    private void wwLock() {

        new Thread(() -> {
            reentrantReadWriteLock.writeLock().lock();
            System.out.println("rwLock01");
            reentrantReadWriteLock.writeLock().unlock();

        }).start();
        new Thread(() -> {
            reentrantReadWriteLock.writeLock().lock();
            System.out.println("rwLock02");
            reentrantReadWriteLock.writeLock().unlock();
        }).start();
    }

    private void rrLock() {

        new Thread(() -> {
            reentrantReadWriteLock.writeLock().lock();
            // reentrantReadWriteLock.readLock().lock();
            System.out.println("wlock");
            reentrantReadWriteLock.writeLock().unlock();
            //reentrantReadWriteLock.readLock().unlock();

        }).start();
        new Thread(() -> {
            reentrantReadWriteLock.readLock().lock();
            System.out.println("rwLock01");
            reentrantReadWriteLock.readLock().unlock();

        }).start();
        new Thread(() -> {
            reentrantReadWriteLock.readLock().lock();
            System.out.println("rwLock02");
            reentrantReadWriteLock.readLock().unlock();
        }).start();

        new Thread(() -> {
            reentrantReadWriteLock.readLock().lock();
            System.out.println("rwLock03");
            reentrantReadWriteLock.readLock().unlock();
        }).start();

    }

    @Test
    public void testCondition() {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        new Thread(() -> {
            try {
                lock.lock();
                lock.lock();
                condition.await();
                System.out.println("continue");
                lock.unlock();
                lock.unlock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                lock.lock();
                condition.await();
                System.out.println("continue2");
                lock.unlock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            lock.lock();
            condition.signal();
            System.out.println("signal");
            lock.unlock();
        }).start();
        System.out.println();
        System.out.println("hello world");




    }







}
