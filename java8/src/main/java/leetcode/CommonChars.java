package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huanghaoxing
 * 1002. 查找常用字符
 */
public class CommonChars {

    public List<String> commonChars(String[] A) {
        List<String> ret = new ArrayList<>();
        if (A == null || A.length == 0) {
            return null;
        }
        List<Map<Character, Integer>> list = new ArrayList<>(A.length);
        for (String s : A) {
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0, length = s.length(); i < length; i++) {
                char c = s.charAt(i);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                } else {
                    map.put(c, 1);
                }
            }
            list.add(map);
        }
        int min = Integer.MAX_VALUE;
        Map<Character, Integer> map = list.get(0);
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            min = Integer.MAX_VALUE;
            for (Map<Character, Integer> characterIntegerMap : list) {
                if (characterIntegerMap.containsKey(entry.getKey())) {
                    min = Math.min(min, characterIntegerMap.get(entry.getKey()));
                } else {
                    min = Integer.MAX_VALUE;
                    break;
                }
            }
            if (min < Integer.MAX_VALUE) {
                for (int i = 0; i < min; i++) {
                    ret.add(entry.getKey().toString());
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        CommonChars commonChars = new CommonChars();
        commonChars.commonChars(new String[]{"bella", "label", "roller"});
    }
}
