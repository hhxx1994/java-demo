/**
 * @author hhx
 * 2017/11/11 10:44
 */
public class ForUtils {
    private static long LOOP = 10000;

    public static void setLoop(long times) {
        LOOP = times;
    }

    public static void loop(Runnable runnable) {
        long start = System.currentTimeMillis();
        for (long i = 0; i < LOOP; i++) {
            runnable.run();
        }
        long end = System.currentTimeMillis();
        System.out.println("time:"+(end-start));
    }

}
