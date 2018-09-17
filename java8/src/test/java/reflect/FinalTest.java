package reflect;

import org.junit.Test;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * @author huanghaoxing
 */
public class FinalTest {

      String name = "abc";

    @Test
    public void test_changeFinal() throws Exception {
        FinalTest finalTest = new FinalTest();
        System.out.println(finalTest.name);
//        Field name = FinalTest.class.getDeclaredField("name");
//        name.setAccessible(true);
//
//        name.set(finalTest,"hhx" );
//
//       // System.out.println("abc");
//        System.out.println(name.get(finalTest));

    }

    @Test
    public void test_invoke() throws Throwable {
        MethodType mt = getMT();
        System.out.println(MethodHandles.lookup().findVirtual(String.class, "equalsIgnoreCase", mt).invoke("aa", "AA"));
    }

    private MethodType getMT() {
        return MethodType.methodType(boolean.class, String.class);
    }
}
