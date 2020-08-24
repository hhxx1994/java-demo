package leetcode;

import com.google.common.collect.Lists;

import java.util.*;

/**
 * @author huanghaoxing
 */
public class LadderLength {

  Map<String, Set<String>> map = new HashMap<>();
  Set<String> visited = new HashSet<>();


  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    preBuild(wordList);
    Queue<String> queue = new LinkedList<>();
    queue.add(beginWord);
    int ret = 0;
    while (!queue.isEmpty()) {
      ret++;
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        String word = queue.remove();
        char[] chars = word.toCharArray();
        for (int j = 0; j < chars.length; j++) {
          char temp = chars[j];
          chars[j] = '*';
          String newWord = new String(chars);
          Set<String> adj = map.getOrDefault(newWord, new HashSet<>());
          for (String s : adj) {
            if (!visited.contains(s)) {
              if (s.equals(endWord)) {
                return ret + 1;
              } else {
                queue.add(s);
              }
              visited.add(s);
            }
          }
          chars[j] = temp;
        }
      }
    }
    return 0;
  }


  /**
   * 预处理
   *
   * @param wordList
   */
  private void preBuild(List<String> wordList) {
    for (String word : wordList) {
      char[] chars = word.toCharArray();
      for (int i = 0; i < word.length(); i++) {
        char temp = chars[i];
        chars[i] = '*';
        String newWord = new String(chars);
        Set<String> set = map.getOrDefault(newWord, new HashSet<>());
        set.add(word);
        map.put(newWord, set);
        chars[i] = temp;
      }
    }
  }

  public static void main(String[] args) {
    LadderLength ladderLength = new LadderLength();
    ladderLength.ladderLength("hit", "cog", Lists.newArrayList("hot", "dot", "dog", "lot", "log"));
  }
}
