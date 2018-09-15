package vm;

import com.sun.jdi.Bootstrap;
import com.sun.jdi.ThreadReference;
import com.sun.jdi.VirtualMachineManager;
import com.sun.jdi.connect.AttachingConnector;
import com.sun.jdi.connect.Connector;
import com.sun.jdi.connect.IllegalConnectorArgumentsException;
import com.sun.tools.attach.VirtualMachine;
import com.sun.tools.attach.VirtualMachineDescriptor;
import com.sun.tools.attach.spi.AttachProvider;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author huanghaoxing
 */
public class VmTest {

    private static final String DT_SOCKET = "dt_socket";
    private static final String HOST = "hostname";
    private static final String PORT = "port";
    private static final String LOCALHOST = "127.0.0.1";

    @Test
    public void test_vm(){
        List<VirtualMachineDescriptor> list = VirtualMachine.list();
        list.forEach(virtualMachineDescriptor -> {
            System.out.println(virtualMachineDescriptor.displayName());
            System.out.println(virtualMachineDescriptor.id());
            AttachProvider provider = virtualMachineDescriptor.provider();

        });
    }


    @Test
    public void test_vmManager() throws IOException, IllegalConnectorArgumentsException {
        VirtualMachineManager virtualMachineManager = Bootstrap.virtualMachineManager();
        AttachingConnector connector = null;
        for (AttachingConnector attachingConnector : virtualMachineManager.attachingConnectors()) {
            if (DT_SOCKET.equals(attachingConnector.transport().name())) {
                connector = attachingConnector;
                break;
            }
        }
        if(connector != null){
            Map<String, Connector.Argument> args = connector.defaultArguments();
            Connector.Argument host = args.get(HOST);
            Connector.Argument port = args.get(PORT);

            host.setValue(LOCALHOST);
            port.setValue("8001");

            com.sun.jdi.VirtualMachine virtualMachine = connector.attach(args);
            for (ThreadReference thread : virtualMachine.allThreads()) {
                System.out.println(thread.name());
            }
        }


    }
}
