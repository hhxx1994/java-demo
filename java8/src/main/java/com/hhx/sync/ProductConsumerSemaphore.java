package com.hhx.sync;

import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class ProductConsumerSemaphore {
	private static final int LENGTH = 10;

	private ReentrantLock lock = new ReentrantLock();

	private int num[] = new int[LENGTH];

	private Semaphore emptyBuffer = new Semaphore(LENGTH);

	private Semaphore fullBuffer = new Semaphore(0);

	private int currentIndex = -1;

	private void lock() {
		lock.lock();
	}

	private void unlock() {
		lock.unlock();
	}

	public void product() {
		try {
			while (true) {
				emptyBuffer.acquire();

				lock();
				num[++currentIndex] = RandomUtils.nextInt();
				System.out.printf("product  index %d , value is %d\n", currentIndex, num[currentIndex]);
			//	TimeUnit.MILLISECONDS.sleep(100);
				unlock();

				fullBuffer.release();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void consumer() {
		try {
			while (true) {
				fullBuffer.acquire();
				lock();
				System.out.printf("consumer index %d , value is %d\n", currentIndex, num[currentIndex--]);
				//TimeUnit.MILLISECONDS.sleep(100);
				unlock();
				emptyBuffer.release();
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
