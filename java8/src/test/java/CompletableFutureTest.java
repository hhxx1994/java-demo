import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Description:
 *
 * @author huang.hao
 * @since 2018-01-11
 */
public class CompletableFutureTest {

    @Test
    public void test01() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(10L);
            } catch (InterruptedException e) {

            }
            int i = 1 / 0;
            return 100;
        });
        future.join();
        // future.get();

        CompletableFuture<Integer> f = new CompletableFuture<>();
        f.complete(100);
        f.get();

        CompletableFuture<String> hello = CompletableFuture.completedFuture("hello world");
        System.out.println(hello.get());

    }

    @Test
    public void testSupplyAsync() {
        Pattern p = Pattern.compile("(\\d+):(\\d+)");
        Matcher m = p.matcher("1000:1|1001:2");

        for (; m.find(); ) {
            System.out.println(m.group(1));
            System.out.println(m.group(2));
        }

//        m.groupCount();   //返回2,因为有2组
//        m.start(1);   //返回0 返回第一组匹配到的子字符串在字符串中的索引号
//        m.start(2);   //返回3
//        m.end(1);   //返回3 返回第一组匹配到的子字符串的最后一个字符在字符串中的索引位置.
//        m.end(2);   //返回7
//        m.group(1);   //返回aaa,返回第一组匹配到的子字符串
//        m.group(2);   //

    }

}
