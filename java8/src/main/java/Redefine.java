import com.sun.jdi.Bootstrap;
import com.sun.jdi.ReferenceType;
import com.sun.jdi.VirtualMachine;
import com.sun.jdi.connect.AttachingConnector;
import com.sun.jdi.connect.Connector;
import com.sun.tools.jdi.SocketAttachingConnector;
import org.jacoco.core.instr.Instrumenter;
import org.jacoco.core.runtime.LoggerRuntime;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Redefine {
    static String CLASS_FILE;
    static String CLASS_NAME;
    static String JACOCO;

    public static void main(String[] args) {
        String host = args[0];
        CLASS_FILE = args[1];
        CLASS_NAME = args[2];
        JACOCO = args[3];
        VirtualMachine vm = connect(host, "8000", "1000");
        if (vm == null) {
            return;
        }
        boolean canRedefineClasses = vm.canRedefineClasses();
        if (!canRedefineClasses) {
            System.out.println("Target vm can not redefine.");
            return;
        }
        try {
            if (CLASS_FILE == null || CLASS_FILE.trim().isEmpty()) {
                System.out.println("Class file is empty");
                return;
            }
            System.out.println("Class name: " + CLASS_NAME);
            System.out.println("Class file: " + CLASS_FILE);

            byte[] classBytes = getClassBytes();

            if ("true".equals(JACOCO)) {
                classBytes = jacocoTransfer(classBytes);
            }

            List<ReferenceType> referenceTypes = vm.classesByName(CLASS_NAME);
            if (referenceTypes == null || referenceTypes.size() == 0) {
                System.out.println("The target class is null.");
                return;
            }
            if (referenceTypes.size() > 1) {
                System.out.println("Find more then one class. Please check your class name.");
                return;
            }

            Map<ReferenceType, byte[]> classToBytes = new HashMap<>();
            ReferenceType referenceType = referenceTypes.get(0);
            classToBytes.put(referenceType, classBytes);
            vm.redefineClasses(classToBytes);

            System.out.println("Redefine success.");
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            vm.dispose();
            System.out.println("Disconnected from target vm.");
        }
    }


    private static byte[] getClassBytes() throws IOException {
        File f = new File(CLASS_FILE);
        if (!f.exists()) {
            throw new FileNotFoundException(CLASS_FILE);
        }
        if (!f.isFile()) {
            System.err.println(f.getName() + " is not a file.");
            throw new IllegalStateException(CLASS_FILE);
        }

        BufferedInputStream in;
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream((int) f.length())) {
            in = new BufferedInputStream(new FileInputStream(f));
            int bufSize = 1024;
            byte[] buffer = new byte[bufSize];
            int len = 0;
            while (-1 != (len = in.read(buffer, 0, bufSize))) {
                bos.write(buffer, 0, len);
            }
            return bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("file read error.");
            throw e;
        }
    }

    public static VirtualMachine connect(String host, String port, String connectTimeout) {
        VirtualMachine vm;
        try {
            List<AttachingConnector> allConnectors = Bootstrap.virtualMachineManager().attachingConnectors();

            SocketAttachingConnector socketAttachingConnector = null;
            for (Connector connector : allConnectors) {
                if (connector instanceof SocketAttachingConnector) {
                    socketAttachingConnector = (SocketAttachingConnector) connector;
                    break;
                }
            }
            if (socketAttachingConnector == null) {
                System.out.println("Can not find SocketAttachingConnector");
                return null;
            }

            Map<String, Connector.Argument> arguments1 = socketAttachingConnector.defaultArguments();
            Connector.Argument hostArg = arguments1.get("hostname");
            Connector.Argument portArg = arguments1.get("port");
            Connector.Argument timeArg = arguments1.get("timeout");
            hostArg.setValue(host);
            portArg.setValue(port);
            timeArg.setValue(connectTimeout);

            System.out.println("Connecting to target vm, host:" + host + " port:" + port);
            vm = socketAttachingConnector.attach(arguments1);
        } catch (Throwable e) {
            e.printStackTrace();
            return null;
        }
        System.out.println("==============================================================================");
        System.out.println(vm.description());
        System.out.println("==============================================================================");
        return vm;
    }

    private static byte[] jacocoTransfer(byte[] classBytes) throws IOException {
        LoggerRuntime runtime = new LoggerRuntime();
        Instrumenter instrumenter = new Instrumenter(runtime);
        byte[] jacocoClassBytes = instrumenter.instrument(classBytes, CLASS_NAME);
        System.out.println("Jacoco transfer success.");
        return jacocoClassBytes;
    }
}
