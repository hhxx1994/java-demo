package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huanghaoxing
 */
public class BitConvert {
    public String convert(int n) {
        List<Integer> integers = new ArrayList<Integer>();
        while (n / 2 != 0) {
            integers.add(n % 2);
            n = n / 2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = integers.size() - 1; i >= 0; i--) {
            stringBuilder.append(integers.get(i));
        }
        return stringBuilder.toString();
    }
}
