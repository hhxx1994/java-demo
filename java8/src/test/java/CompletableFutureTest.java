import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

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

    public void testSupplyAsync() {
//        CompletableFuture.supplyAsync(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(10);
//                throw new IllegalArgumentException();
//            } catch (InterruptedException e) {
//
//            }
//            return "completed";
//        }).whenComplete((v,e)->{
//
//        })



    }

}
