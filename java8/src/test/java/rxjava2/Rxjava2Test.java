package rxjava2;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

/**
 * @author huanghaoxing
 */
public class Rxjava2Test {


    @Test
    public void test_helloWorld() {
        Disposable subscribe = Observable.just("hello world")
                .subscribe(s -> System.out.println(s + "onNext"),
                        System.out::println,
                        () -> System.out.println("onComplete"));

    }

    @Test
    public void test_schedulers() {
        Observable.create(e -> {
            for (int i = 0; ; i++) {
                e.onNext(i);
                //Thread.sleep(RandomUtils.nextInt(100,2000 ));
                // System.out.println("observable-->"+Thread.currentThread().getName());
            }
        })
                .subscribeOn(Schedulers.computation())
                .observeOn(Schedulers.single())
                .subscribe(item -> {

                    System.out.println("observer-->" + Thread.currentThread().getName() + "-->" + item);
                    Thread.sleep(RandomUtils.nextInt(100, 1000));

                });
        System.out.println("end");

        while (true) ;
    }

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        Observable.zip(Observable.fromCallable(() -> {

                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(3000);
                    return "a";

                }).subscribeOn(Schedulers.io()),

                Observable.fromCallable(() -> {
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(3000);
                    return "b";
                }).subscribeOn(Schedulers.io()),

                (s1, s2) -> {
                    System.out.println(s1 + s2);
                    return "c";
                }).subscribeOn(Schedulers.io())

                .observeOn(Schedulers.computation())
                .subscribe(item -> {
                    long end = System.currentTimeMillis();
                    System.out.println(end - start);
                });

        System.out.println("end");
        Thread.sleep(200000);

    }


}
