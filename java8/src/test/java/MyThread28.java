public class MyThread28 extends Thread
{
    private  boolean isRunning = true;

    public boolean isRunning()
    {
        return isRunning;
    }

    public void setRunning(boolean isRunning)
    {
        this.isRunning = isRunning;
    }
    
    public void run()
    {
        System.out.println("进入run了");
        while (isRunning == true){}
        System.out.println("线程被停止了");
    }

    public static void main(String[] args)
    {
        try
        {
            MyThread28 mt = new MyThread28();
            mt.start();
            Thread.sleep(1000);
            mt.setRunning(false);
            System.out.println("已赋值为false");
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}