package threadpools;

import org.junit.Test;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author huanghaoxing
 */
public class ThreadPoolsTest {

    @Test
    public void test_threadPools(){
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(1, 5, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        threadPoolExecutor.execute(()-> System.out.println("hello world"));
        threadPoolExecutor.execute(()-> System.out.println("hello world2"));
    }
}
