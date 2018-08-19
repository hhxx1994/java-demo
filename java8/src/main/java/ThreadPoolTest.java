import java.util.concurrent.*;

public class ThreadPoolTest {

    static class LocalVariable {
        private Long[] a = new Long[1024 * 1024];
    }

    // (1)
    final static ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5, 5, 300, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>());

    // (2)
    final static ThreadLocal<LocalVariable> localVariable = new ThreadLocal<LocalVariable>();

    public static void main(String[] args) throws InterruptedException {
        // (3)
        for (int i = 0; i < 50; ++i) {
            poolExecutor.execute(() -> {
                // (4)
                localVariable.set(new LocalVariable());
                // (5)
                System.out.println("use local varaible");
                //localVariable.remove();

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            Thread.sleep(100);

        }
        // (6)
        System.out.println("pool execute over");
    }
}