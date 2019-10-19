package leetcode;

import java.util.Arrays;

/**
 * @author huanghaoxing
 * c
 */
public class Bttsp {
    public int n;//图G的顶点数
    public int[] x;//当前解
    public int[] bestx;//当前最优解
    public float bestc = Integer.MAX_VALUE;//当前最优值
    public float cc;//当前费用
    public float[][] a;//图G的邻接矩阵

    public void backtrack(int i) {
        // 处理递归边界
        if (i == n - 1) {
            if (a[n - 1][0] != -1 && cc + a[n - 1][0] < bestc) {
                // 当前最优值
                bestc = cc + a[n - 1][0];
                bestx = Arrays.copyOf(x, x.length);
                return;
            }
        }
        for (int index = i; index < n; index++) {
            if (a[i][index] != -1 && cc + a[i][index] < bestc) {
                cc += a[i][index];
                swap(x, index, i);
                backtrack(i + 1);
                // 回溯
                cc -= a[i][index];
                swap(x, index, i);
            }
        }

    }

    private void swap(int[] x, int index, int i) {
        int temp = x[index];
        x[index] = x[i];
        x[i] = temp;
    }

}
