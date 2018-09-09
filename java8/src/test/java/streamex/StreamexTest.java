package streamex;

import com.google.common.collect.Lists;
import com.hhx.tag.User;
import one.util.streamex.IntStreamEx;
import one.util.streamex.StreamEx;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * @author huanghaoxing
 */
public class StreamexTest {

    @Test
    public void test_toMap(){
        Map<String, User> stringUserMap = StreamEx.of(getUsers()).toMap(User::getId, Function.identity());
        StreamEx.of(getUsers()).mapToEntry(User::getId,Function.identity());
    }

    @Test
    public void test_distinct(){

        StreamEx<User> distinct = StreamEx.of(getUsers()).distinct(User::getId);


    }


    @Test
    public void test_filterBy(){
        StreamEx.of(getUsers()).filterBy(User::getId,"123").forEach(System.out::println);
    }

    @Test
    public void test_toArray(){
        User[] users = StreamEx.of(getUsers()).toArray(User[]::new);
    }

    @Test
    public void test_append(){
        StreamEx.of(getUsers()).append(getUsers2());
    }

    /**
     * For example, writing {@code StreamEx.of(1, 2).cross("a", "b")}, you will
     *      * have an ordered stream of the following entries: {@code [1, "a"], [1, "b"],
     *      * [2, "a"], [2, "b"]}.
     */
    @Test
    public void test_cross(){
        StreamEx.of(1, 2).cross("a", "b").forEach(System.out::println);
    }

    @Test
    public void test_cartesianPower(){
        StreamEx.cartesianPower(1,getUsers()).forEach(System.out::println);


    }




    @Test
    public void test_cartesianProduct(){
        List<List<User>> users = new ArrayList<>();
        users.add(getUsers());
        users.add(getUsers2());
        StreamEx.cartesianProduct(users).forEach(System.out::println);
    }


    @Test
    public void test_fold(){
        System.out.println(IntStreamEx.range(1, 100).foldLeft(0, (a, b) -> a + b));
    }

    @Test
    public void test_aa(){
        String[] ints = {"1"};
        //Arrays.stream(ints).collect(MoreCollectors.intersecting())
    }

    private List<User> getUsers() {
        List<User> users = Lists.newArrayList();
        User user = new User();
        user.setId("123");
        user.setUserName("fff");
        User user2 = new User();
        user2.setId("134");
        user2.setUserName("fffsd");
        users.add(user);
        users.add(user2);
        return users;
    }

    private List<User> getUsers2() {
        List<User> users = Lists.newArrayList();
        User user = new User();
        user.setId("abc");
        user.setUserName("fffsad");
        User user2 = new User();
        user2.setId("cde");
        user2.setUserName("fff");
        users.add(user);
        users.add(user2);
        return users;
    }
}
