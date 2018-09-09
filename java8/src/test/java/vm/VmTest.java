package vm;

import com.sun.tools.attach.VirtualMachine;
import com.sun.tools.attach.VirtualMachineDescriptor;
import com.sun.tools.attach.spi.AttachProvider;
import org.junit.Test;

import java.util.List;

/**
 * @author huanghaoxing
 */
public class VmTest {

    @Test
    public void test_vm(){
        List<VirtualMachineDescriptor> list = VirtualMachine.list();
        list.forEach(virtualMachineDescriptor -> {
            System.out.println(virtualMachineDescriptor.displayName());
            System.out.println(virtualMachineDescriptor.id());
            AttachProvider provider = virtualMachineDescriptor.provider();

        });
    }
}
