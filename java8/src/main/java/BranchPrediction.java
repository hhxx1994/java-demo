import org.apache.commons.lang3.ArrayUtils;

/**
 * @author huanghaoxing
 */
public class BranchPrediction {
    private static final int LENGTH = 100000;

    public static void main(String[] args) {

        int[] arrays = new int[LENGTH];
        for (int i = 0; i < LENGTH; i++) {
            arrays[i] = i;
        }


        long t1 = loop(arrays);

        ArrayUtils.shuffle(arrays);

        long t2 = loop(arrays);

        System.out.println(t1);
        System.out.println(t2);
    }



    private static long loop(int[] arrays) {
        long start = System.nanoTime();
        for (int i = 0; i < LENGTH; i++) {
            if (arrays[i] < LENGTH / 2) {
                //do nothing
            }
        }
        long end = System.nanoTime();
        return end - start;
    }
}
