import org.junit.Test;

/**
 * @author haoxing_h
 */
public class CronUtilsTest {
    @Test
    public void run() throws Exception {
        CronUtils.addTask(()->System.out.println("1"),1);
        CronUtils.addTask(()->System.out.println("2"),2);
        CronUtils.addTask(()->System.out.println("5"),5);
        CronUtils.addTask(()->System.out.println("3600"),3600);
        while(true);
    }

}