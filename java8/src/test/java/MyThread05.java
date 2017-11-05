public class MyThread05 extends Thread
{
    public MyThread05() {
        System.out.println(Thread.currentThread().getName());
        System.out.println(this.getName());
    }

    
    public void run()
    {

        System.out.println(
                Thread.currentThread().getName());
        System.out.println(this.getName());

    }

    public static void main(String[] args)
    {
        MyThread05 mt5 = new MyThread05();
        mt5.start();


    }
}