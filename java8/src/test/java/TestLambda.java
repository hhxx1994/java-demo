/**
 * @author haoxing_h
 */
public class TestLambda {
    public void testLambda(){
        int a=10;
        Runnable r1=()->{
           // int a=2;
            System.out.println(a);
        };
    }

}
