import org.junit.Test;

/**
 * @author hhx
 * 2017/11/11 10:40
 */
public class TestBoolean {
    @Test
    public void testBoolean() {
        ForUtils.setLoop(100000000000L);
        ForUtils.loop(()->{
            Boolean aBoolean = new Boolean(true);
            Boolean aBoolean1 = new Boolean(false);
        });
        ForUtils.loop(()->{
            Boolean aBoolean = Boolean.valueOf(true);

            Boolean aBoolean1 = Boolean.valueOf(false);
        });
    }
    @Test
    public void testFinal(){


    }
}
