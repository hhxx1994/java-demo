import org.junit.Test;

/**
 * Description:
 *
 * @author huang.hao
 * @since 2018-01-22
 */
public class IntegerTest {

    @Test
    public void testInteger() {

        Integer i1 = 40;
        Integer i2 = 40;
        Integer i3 = 0;
        Integer i4 = new Integer(40);
        Integer i5 = new Integer(40);
        Integer i6 = new Integer(0);

        System.out.println(i1 == i2);
        System.out.println(i1 == i2 + i3);
        System.out.println(i1 == i4);
        System.out.println(i4 == i5);
        System.out.println(i4 == i5 + i6);
        System.out.println(40 == i5 + i6);

    }
}
