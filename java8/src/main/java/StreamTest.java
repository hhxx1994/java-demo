import com.google.common.collect.Lists;
import org.apache.commons.lang3.RandomUtils;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author huanghaoxing
 */
public class StreamTest {

    public static void main(String[] args) {
        List<Integer> arrayList = Lists.newArrayList();
        for (int i = 0; i < 40; i++) {
            arrayList.add(RandomUtils.nextInt(0, 100000));
        }
        try {
            System.out.println(arrayList.parallelStream()
                    .map(e -> {
                        e = e + 1;
                        System.out.println("first map");
                        return e;
                    })
                    .sorted(new Comparator<Integer>() {

                        @Override
                        public int compare(Integer o1, Integer o2) {
                            return o1 - o2;
                        }
                    })
                    .map(e -> {
                        e = e * 2;
                        System.out.println("second map");
                        if (e > 0) {
                            throw new RuntimeException("aaa");
                        }
                        return e;
                    })
                    .sorted(new Comparator<Integer>() {

                        @Override
                        public int compare(Integer o1, Integer o2) {
                            return o1 - o2;
                        }
                    })
                    .collect(Collectors.toList()));

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(arrayList.parallelStream()
                .map(e -> {
                    e = e + 1;
                    System.out.println("first map");
                    return e;
                })
                .sorted(new Comparator<Integer>() {

                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o1 - o2;
                    }
                })
                .map(e -> {
                    e = e * 2;
                    System.out.println("second map");
//                    if (e > 0) {
//                        throw new RuntimeException("aaa");
//                    }
                    return e;
                })
                .sorted(new Comparator<Integer>() {

                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o1 - o2;
                    }
                })
                .collect(Collectors.toList()));


    }
}
