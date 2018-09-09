package jdk9;

import com.hhx.tag.User;
import net.kemitix.jdk9to8.java.util.Optional;
import org.jooq.lambda.Seq;
import org.junit.Test;

import java.util.Objects;

/**
 * @author huanghaoxing
 */
public class OptionalTest {

    @Test
    public void test_optional(){
        Optional.ofNullable(new User())
                .filter(u-> Objects.nonNull(u.getId()))
                .ifPresentOrElse(System.out::println, ()-> System.out.println("user's name is null"));

        //Optional.ofNullable(Lists.newArrayList()).stream().map()

        Seq.of(1, 2).crossJoin(Seq.of("A", "B"));

    }
}
