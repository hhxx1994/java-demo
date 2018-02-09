import org.junit.Test;

/**
 * Description:
 *
 * @author huang.hao
 * @since 2018-02-09
 */
public class InOutParameterTest {

    public void inputParameter(A in) {
        A a = new A();
        a.setA(10);
        in = a;
    }

    @Test
    public void test() {
        A b = new A();
        b.setA(100);
        inputParameter(b);
        System.out.println(b);
    }

    class A {
        private int a;

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        @Override
        public String toString() {
            return "A{" +
                    "a=" + a +
                    '}';
        }
    }

}
