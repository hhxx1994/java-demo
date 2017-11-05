import org.junit.Test;

import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author hhx
 * @date 2017/11/5 18:17
 * @description
 */
public class TestJdkFuture {
    @Test
    public void testJkdFuture()throws Exception{
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        Future<String> submit = threadPoolExecutor.submit(() -> "aa");
        submit.get(10,TimeUnit.MINUTES);



    }
}
