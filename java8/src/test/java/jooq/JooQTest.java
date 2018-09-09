package jooq;

import com.google.common.collect.Lists;
import com.hhx.tag.User;
import org.jooq.lambda.Seq;
import org.junit.Test;

import java.util.List;

/**
 * @author huanghaoxing
 */
public class JooQTest {

    @Test
    public void test_test(){
        Seq.ofType(getUsers().stream(), User.class)
                .innerJoin(getUsers2(), (t,u)->t.getUserName().equals(u.getUserName()))
                .forEach(System.out::println);

        Seq.ofType(getUsers().stream(),User.class )
                .toMap(User::getId);

        Seq.ofType(getUsers().stream(),User.class )
                .distinct(User::getId);





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
