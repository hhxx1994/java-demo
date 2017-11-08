import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.IntFunction;

/**
 * @author haoxing_h
 */
public class TestIntegerToString {

    public static final int CONDITION = 1000000;

    @Test
    public void testIntegerToString(){
        function(String::valueOf);
        function(Integer::toString);
    }

    public void function(IntFunction<String> function){
        long start = System.currentTimeMillis();
        for(int i = 0; i< CONDITION; i++){
            function.apply(i);
        }
        long end=System.currentTimeMillis();
        System.out.println(end-start);
    }
}
