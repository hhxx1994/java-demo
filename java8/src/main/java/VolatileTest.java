/**
 * Description:
 *
 * @author huang.hao
 * @since 2018-01-10
 */
public class VolatileTest {
    private volatile  int i=0;

    public void test(){
        i++;
    }

    public void read(){
        System.out.println(i);
    }


}
