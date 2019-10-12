package leetcode;

import java.util.Arrays;

/**
 * @author huanghaoxing
 */
public class Loading {
    int c = 750;    //背包容量
    int bestv = 0;//迄今最大的收益
    int[] path;

    public int getBestLoading(int[] w, int[] v) {
        getBestLoading(0, 0, w, v, 0, new int[w.length]);
        return 0;
    }

    public void getBestLoading(int cw, int cv, int[] w, int[] v, int i, int[] V) {
        if (i >= w.length) {
            if (cv > bestv) {
                bestv = cv;
                path = Arrays.copyOf(V, V.length);
            }
            return;
        }
        if (cw + w[i] <= c) {
            V[i] = 1;
            getBestLoading(cw + w[i], cv + v[i], w, v, i + 1, V);
            V[i] = 0;
            getBestLoading(cw, cv, w, v, i + 1, V);
        }
    }

    public static void main(String[] args) {
        Loading loading = new Loading();
        int[] v = {135, 139, 149, 150, 156, 163, 173, 184, 192, 201, 210, 214, 221, 229, 240};
        loading.getBestLoading(new int[]{70, 73, 77, 80, 82, 87, 90, 94, 98, 106, 110, 113, 115, 118, 120}, v);
        System.out.println(loading.bestv);
        int sum = 0;
        for (int i = 0; i < loading.path.length; i++) {
            System.out.print(loading.path[i]);
            System.out.print(" ");
            if (loading.path[i] == 1) {
                sum += v[i];
            }
        }
        System.out.println();
        System.out.println(sum);
    }
}
