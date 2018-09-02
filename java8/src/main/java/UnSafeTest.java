import sun.misc.Unsafe;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class UnSafeTest {

    public static final int TIMES = 10000000;

    public static void main(String[] args) {
        try {
            Constructor<Unsafe> con = (Constructor<Unsafe>) Class.forName("sun.misc.Unsafe").getDeclaredConstructor();
            con.setAccessible(true);
            User user = new User();
            Unsafe UNSAFE = con.newInstance(null);
            Field filed = user.getClass().getDeclaredField("age");
            long s1=System.currentTimeMillis();
            for(int i = 0; i< TIMES; i++){
                user.setAge(i);
            }
            System.out.println(System.currentTimeMillis()-s1);

            long ageOffset = UNSAFE.objectFieldOffset(filed);

            long s2=System.currentTimeMillis();
            for(int i=0;i<TIMES;i++){
                UNSAFE.putInt(user, ageOffset, i);
            }
            System.out.println(System.currentTimeMillis()-s2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}