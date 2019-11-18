package leetcode;

/**
 * @author huanghaoxing
 */
public class RemoveOuterParentheses {

    public String removeOuterParentheses(String S) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        int start = 0;
        int end = 0;
        char[] chars = S.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                sb.append(S, start + 1, end);
                start = i + 1;
            }
            end++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveOuterParentheses removeOuterParentheses = new RemoveOuterParentheses();
        System.out.println(removeOuterParentheses.removeOuterParentheses("(()())(())(()(()))"));
    }
}
