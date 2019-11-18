package leetcode;

/**
 * @author huanghaoxing
 */
public class BalancedStringSplit {

    public int balancedStringSplit(String s) {
        int count = 0;
        int ret = 0;
        for (char c : s.toCharArray()) {
            if (c == 'L') {
                count--;
            } else if (c == 'R') {
                count++;
            }
            if (count == 0) {
                ret++;
            }
        }
        return ret;
    }
}
