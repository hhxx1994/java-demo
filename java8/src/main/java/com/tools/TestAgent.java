package com.tools;

import java.lang.instrument.Instrumentation;

public class TestAgent {
    public static void agentmain(String args, Instrumentation inst)
            throws Exception {
        System.out.println("Args:" + args);
    }

    public static void premain(String args, Instrumentation inst)
            throws Exception {
//        System.out.println("Pre Args:" + args);
//        Class[] classes = inst.getAllLoadedClasses();
//        for (Class clazz : classes) {
//            System.out.println(clazz.getName());
//        }

        System.out.println("hello main");
    }
}