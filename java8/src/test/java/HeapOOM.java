import java.util.ArrayList;
import java.util.List;

/**
 * @author hhx
 * 2017/11/23 0:03
 */
public class HeapOOM {
    static class OOMObject{}

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while(true){
            list.add(new OOMObject());
        }
    }
}
