package streamex;

import com.google.common.collect.Lists;
import com.hhx.tag.User;
import one.util.streamex.StreamEx;
import org.junit.Test;

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
    public void test_toArray(){
        User[] users = StreamEx.of(getUsers()).toArray(User[]::new);
    }

    private List<User> getUsers() {
        List<User> users = Lists.newArrayList();
        User user = new User();
        user.setId("123");
        user.setUserName("fff");
        User user2 = new User();
        user2.setId("134");
        user2.setUserName("fff");
        users.add(user);
        users.add(user2);
        return users;
    }
}
