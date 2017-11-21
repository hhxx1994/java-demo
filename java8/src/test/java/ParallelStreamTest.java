import java.util.ArrayList;
import java.util.stream.IntStream;
import org.junit.Test;

/**
 * @author haoxing_h
 */
public class ParallelStreamTest {

    @Test
    public void palallelStreamTest() {
        ArrayList<Integer> list = new ArrayList<>();
        IntStream.range(1,10000000).parallel().forEach(list::add);
        System.out.println(list.size());
    }

}
