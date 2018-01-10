/**
 * Description:
 *
 * @author huang.hao
 * @since 2018-01-10
 */
public class SychonizedTest {
    public static synchronized void test01(){
        int i=1;
        i++;
    }
    public void test02(){
        int i=0;
        synchronized (this){
            i++;
        }

    }

    public synchronized void test03() {
        int i=0;
        i++;
    }

}
