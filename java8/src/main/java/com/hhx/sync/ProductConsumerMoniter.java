package com.hhx.sync;

import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProductConsumerMoniter {

	private static final int LENGTH = 10;


	private int num[] = new int[LENGTH];

	private int currentIndex = -1;

	private ReentrantLock lock = new ReentrantLock();

	private Condition condition = lock.newCondition();

	private void await() {
		try {
			condition.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void singal() {
		condition.signal();
	}

	private void lock() {
		lock.lock();
	}

	private void unlock() {
		lock.unlock();
	}


	public void product() {
		try {
			while (true) {
				lock();
				while (currentIndex == LENGTH) {
					await();
				}
				num[++currentIndex] = RandomUtils.nextInt();
				System.out.printf("product  index %d , value is %d\n", currentIndex, num[currentIndex]);
				TimeUnit.MILLISECONDS.sleep(100);
				singal();
				unlock();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void consumer() {
		try {
			while (true) {
				lock();
				while (currentIndex == 0) {
					await();
				}
				System.out.printf("consumer index %d , value is %d\n", currentIndex, num[currentIndex--]);
				TimeUnit.MILLISECONDS.sleep(100);
				singal();
				unlock();
			}
		} catch (InterruptedException e) {


		}

	}
	public static void main(String[] args) {
		ProductConsumerSemaphore productConsumerSemaphore = new ProductConsumerSemaphore();

		int producter = 2;
		int consumer = 10;

		int totalThread = producter + consumer;
		ArrayList<Thread> threads = new ArrayList<>(totalThread);

		for (int i = 0; i < producter; i++) {
			Thread thread = new Thread(productConsumerSemaphore::product);
			threads.add(thread);
			thread.start();
		}

		for (int i = 0; i < consumer; i++) {
			Thread thread = new Thread(productConsumerSemaphore::consumer);
			threads.add(thread);
			thread.start();
		}

		try {
			for (Thread thread : threads) {
				thread.join();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}


	}

}
