import org.junit.Test;

import java.util.HashMap;

/**
 * @author hhx
 * 2017/11/11 18:49
 */
public class TeshHashCode {
    @Test
    public void testHashCode(){
        HashMap<User, String> map = new HashMap<>();
        User hhx = new User("hhx", "123456");
        map.put(hhx,"1");
        hhx.setName("hhxx1994");
        String s = map.get(hhx);
        System.out.println(s);
        map.put(hhx,"123456");
        System.out.println(map.size());
        while(true);
    }
}
