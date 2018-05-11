import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.function.Function;

public class TestCount {

    public long count_num(int[] array) {
        long count = 0;
        for (int i = 0, len = array.length; i < len; i++) {
           if (array[i] >= 50)
                count += array[i];

        }
        return count;
    }

    @Test
    public void test() {
        int[] a = new int[10000000];
        for (int i = 0; i < a.length; i++) {
            a[i] = RandomUtils.nextInt() % 128;

        }

        System.out.println("time is " + getTime(a, 1000, this::count_num));

        Arrays.sort(a);

        System.out.println("time is " + getTime(a, 1000, this::count_num));

    }

    public long getTime(int[] array, long time, Function<int[], Long> function) {
        long start = System.currentTimeMillis();
        while (time-- != 0)
            function.apply(array);
        long end = System.currentTimeMillis();
        return end - start;
    }

    @Test
    public void test2() {

        int a = 10;
        int b = 20;
        long tmp = 0;
        long  count =20000000000L;
        long start = System.currentTimeMillis();
        for (long i = 0; i < count; i++) {
            if (a>b) {
                tmp++;
            }else{
                tmp++;
            }
        }
        long end = System.currentTimeMillis();

        for (long i = 0; i < count; i++)
            if (a < b) {
                tmp++;
            } else {
                tmp++;
            }
        long end2 = System.currentTimeMillis();

        System.out.println(end - start);
        System.out.println(end2 - end);


    }




}
