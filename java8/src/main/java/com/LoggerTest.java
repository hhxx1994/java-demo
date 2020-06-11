package com;

import java.io.IOException;

/**
 * @author huanghaoxing
 */
public class LoggerTest {

    public static void main(String[] args) throws IOException {
        System.out.println("start");

        {
            System.out.println("body");
        }
        System.out.println("end");
    }
}
