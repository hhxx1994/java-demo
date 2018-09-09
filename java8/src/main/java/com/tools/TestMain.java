package com.tools;

public class TestMain {
    public static void main(String[] args) throws InterruptedException {
        while (true) {
            Thread.sleep(10000);
            new Thread(new WaitThread()).start();
        }
    }
    static class WaitThread implements Runnable {
        @Override
        public void run() {
            System.out.println("Hello");
        }
    }

}
