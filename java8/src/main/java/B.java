import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class B extends A {
    @Override
    public void sayHello() {
        System.out.println("hello, i am child B");
    }

  public static void main(String[] args) throws Exception {
    ExecutorService executorService = Executors.newFixedThreadPool(2);
    Future<Integer> submit = executorService.submit(() -> 1);
    submit.get();
  }
}