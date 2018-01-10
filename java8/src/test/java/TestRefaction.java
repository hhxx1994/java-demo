import java.lang.reflect.Method;

/**
 * Description:
 *
 * @author huang.hao
 * @since 2018-01-05
 */
public class TestRefaction {
    public void a(String[] args) {
        System.out.println("a");
    }

    public static void main(String[] args) throws Exception {
        TestRefaction obj = new TestRefaction();
        Method m = obj.getClass().getMethod("a", String[].class);

        m.invoke(obj, new String[1]);  // new String[1] 其实是null，是一个object
        m.invoke(obj, (Object) new String[] {}); // 这里强制转成了object，所以也是object
        m.invoke(obj, new String[] {}); // 报错，这里是个数组，是个object数组，a方法只有一个参数，所以报错

    }

}
