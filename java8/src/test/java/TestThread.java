import org.junit.Test;

/**
 * @author hhx
 * @date 2017/11/5 20:09
 * @description
 */
public class TestThread {
    static  Integer integer=new Integer(10);

    @Test
    public  void testInterrupt()throws Exception{

        Thread thread = new Thread(() -> {
            try {
                integer=30;
                System.out.println("thread is running");
                long start = System.currentTimeMillis();
                while(!(System.currentTimeMillis() -start > 1000*5)){
                   // System.out.println("thread is running");
                }
                //Thread.sleep(1000 * 10);
                System.out.println("thread end");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(Thread.currentThread().isInterrupted());
            }
        });
        thread.start();
        System.out.println("main is running...");
        Thread.sleep(1000*1);
        thread.interrupt();
        System.out.println("main is running---->");
        while(true){
            System.out.println(thread.isInterrupted());
        }
    }

    public static void main(String[] args) throws Exception{
        //testInterrupt();
    }
    public static User user=new User();

    @Test
   public void testThreadStopUnsafe(){
//        new Thread(()->{
//            while(!Objects.equals(user.getName(),user.getId())){
//                System.out.println(user.toString());
//            }
//        }).start();
   }
   @Test
   public void testStartTwoTimes(){
       Thread thread = new Thread(() -> System.out.println("thread"));
       thread.start();
       thread.start();
       while(true);
   }
}
