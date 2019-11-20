package leetcode;

/**
 * @author huanghaoxing
 */
public class SortedSquares {
    public int[] sortedSquares(int[] A) {
        int[] ret = new int[A.length];
        int left = 0;
        int right = A.length - 1;
        int index = right;
        while (index > 0) {
            int i = A[left] * A[left];
            int j = A[right] * A[right];
            if (i < j) {
                ret[index--] = j;
                right--;
            } else {
                ret[index--] = i;
                left++;
            }
        }
        return ret;
    }


}
