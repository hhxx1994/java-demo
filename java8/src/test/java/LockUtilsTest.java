import org.junit.Test;

/**
 * @author hhx
 * 2017/11/8 22:17
 */
public class LockUtilsTest {

    public static final int COUNT = 10;

    @Test
    public void lock() throws Exception {
        for (int i = 0; i < COUNT; i++) {
            new Thread(() -> {
                LockUtils.lock("1", () -> {
                    int count = 10;
                    while (count-- > 0) {
                        System.out.println(count);
                    }
                });
            }).start();
        }
        while (true) ;

    }

}