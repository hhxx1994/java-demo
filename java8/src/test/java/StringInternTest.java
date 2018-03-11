import org.junit.Test;

/**
 * @author hhx
 * 2017/11/21 9:45
 */
public class StringInternTest {
    @Test
    public void testIntern(){
        equals();
//        String str1 = new String("SEU")+ new String("Calvin");
//        System.out.println(str1.intern() == str1);
//        String seuCalvin = "SEUCalvin";
//        System.out.println(str1 == seuCalvin);

    }
    static final int MAX = 100000;
    static final String[] arr = new String[MAX];

    public static void main(String[] args) throws Exception {
//        //为长度为10的Integer数组随机赋值
//        Integer[] sample = new Integer[10];
//        Random random = new Random(1000);
//        for (int i = 0; i < sample.length; i++) {
//            sample[i] = random.nextInt();
//        }
//        //记录程序开始时间
//        long t = System.currentTimeMillis();
//        //使用/不使用intern方法为10万个String赋值，值来自于Integer数组的10个数
//        for (int i = 0; i < MAX; i++) {
//            arr[i] = new String(String.valueOf(sample[i % sample.length]));
//            //arr[i] = new String(String.valueOf(sample[i % sample.length])).intern();
//        }
//        System.out.println((System.currentTimeMillis() - t) + "ms");
//        System.gc();
//        while(true);
        equals();
    }

    public static void equals() {
        String s = new String("1");
        s.intern();
        String s2 = "1";
        System.out.println(s == s2);

        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);
    }
}
