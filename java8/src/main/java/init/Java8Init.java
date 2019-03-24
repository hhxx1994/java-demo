package init;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huanghaoxing
 */
public class Java8Init {

    public static void main(String[] args) {
        // subclass
        List<String> list = new ArrayList<String>() {{
            add("q");
            add("b");
        }};
        Map<String, String> map = new HashMap<String, String>() {{
            put("a", "b");
        }};
        //String a = new String(){{}};
    }
}
