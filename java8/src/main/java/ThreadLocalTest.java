/**
 * @author huanghaoxing
 */
public class ThreadLocalTest {

    public static void main(String[] args) {
        aa();
        ThreadLocal<Object> threadLocal02 = new ThreadLocal<>();
        threadLocal02.set("bb");

    }


    public static void aa(){
        ThreadLocal<Object> threadLocal01 = new ThreadLocal<>();
        byte[] bytes = new byte[1024 * 1024 * 100];
        threadLocal01.set(bytes);
    }
}
