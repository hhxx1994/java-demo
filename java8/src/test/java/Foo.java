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
        System.out.println(new Foo().getBar());
    }

}