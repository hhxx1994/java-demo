package leetcode;

/**
 * @author huanghaoxing
 */
public class JudgeCircle {
    public boolean judgeCircle(String moves) {
        int ud = 0;
        int lr = 0;
        for (int i = 0; i < moves.length(); i++) {
            char c = moves.charAt(i);
            if (c == 'U') {
                ud++;
            } else if (c == 'D') {
                ud--;
            } else if (c == 'L') {
                lr++;
            } else {
                lr--;
            }
        }
        if (ud == 0 && lr == 0) {
            return true;
        }
        return false;

    }
}
