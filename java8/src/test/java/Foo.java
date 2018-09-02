import org.junit.Test;

public class Foo {

    private volatile Bar bar = null;

    public Bar getBar() {
        if (bar == null) {
            synchronized(this) {
                if (bar == null) {
                    bar = new Bar();
                }
            }
        }
        return bar;
    }

    public static void main(String[] args) throws Exception{

    }


    @Test
    public void test_aa(){
        Enm e =null;
        switch (e){
            case A:
                System.out.println("df");
                break;
            default:
                System.out.println("cc");
        }
    }

}