import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author haoxing_h
 */
public class CronTest {
    @Test
    public void run() throws Exception {
        Cron.run();
        Cron.addTask(()->System.out.println("1"),1);
        Cron.addTask(()->System.out.println("2"),2);
        Cron.addTask(()->System.out.println("5"),5);
        Cron.addTask(()->System.out.println("3600"),3600);
        while(true);
    }

}