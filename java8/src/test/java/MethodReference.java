import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author hhx
 */
public class MethodReference {
    private int port = 30;

    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> predicate) {
        return inventory.stream().filter(predicate).collect(Collectors.toList());
    }

    @Test
    public void testFileHidden() {
        ArrayList<Apple> inventory = new ArrayList<>();
        filterApples(inventory, (Apple apple) -> apple.isGreenApples());
        filterApples(inventory, Apple::isGreenApples);
        filterApples(inventory, Apple::isWeightApples);
        Map<String, List<Apple>> collect = inventory.stream()
                .filter(Apple::isGreenApples)
                .collect(Collectors.groupingBy(Apple::getColor));
        inventory.stream().filter((Apple apple) -> "green".equals(apple.getColor()));
        inventory.sort(Comparator.comparing(Apple::getColor).thenComparing(Apple::getWeight));
        Predicate<Apple> predicate = Apple::isGreenApples;
        predicate.and(Apple::isWeightApples);
        //Arrays.asList("1234", "3456").stream().map(str -> str.split("")).flatMap(Arrays::stream).collect(Collectors.toList())
        //Arrays.asList("1234","2345").stream()

        //  Stream.iterate(0,n -> n+1).parallel().sequential()


    }

    public void testLocalVariable() {
        Integer portNumber = 80;
        Runnable runnable = System::currentTimeMillis;
        Runnable runnable2 = portNumber::hashCode;
        port = 40;
        Function<Integer, Apple> a = Apple::new;
        a.apply(10);

    }

    @Test
    public void testOptional() {
        Apple apple = null;
        String color = Optional.ofNullable(apple).map(Apple::getColor).map(String::toUpperCase).orElse(null);
        System.out.println(color);
    }

    @Test
    public void testGuavaOptional() {
        Apple apple = null;
        com.google.common.base.Optional<Apple> appleOptional = com.google.common.base.Optional.fromNullable(apple);
        String s = appleOptional.transform(Apple::getColor).transform(String::toUpperCase).orNull();
        System.out.println(s);

    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    class Apple {
        private String color;
        private Integer weight;

        public Apple(Integer weight) {
            this.weight = weight;
        }

        public boolean isGreenApples() {
            return "green".equals(color);
        }

        public boolean isWeightApples() {
            return weight > 100;
        }
    }


}
