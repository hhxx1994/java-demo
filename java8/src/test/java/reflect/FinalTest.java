package reflect;

import org.junit.Test;

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
}
