package com.tools;

import com.sun.tools.attach.VirtualMachine;

public class Main {
    public static void main(String[] args) throws Exception {
        VirtualMachine vm = null;
        String agentjarpath = "/Users/huanghaoxing/source/java-demo/java8/src/main/java/com/tools/testAgent.jar"; //agentjar路径
        vm = VirtualMachine.attach("10157");//目标JVM的进程ID（PID）
        vm.loadAgent(agentjarpath, "This is Args to the Agent.");
        vm.detach();
    }
}
