package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huanghaoxing
 */
public class WordBreak {
  int[] memo;

  class Node {
    boolean isWord;
    Map<Character, Node> next = new HashMap<>();
  }

  Node root;

  private void buildPrefixTree(List<String> wordDict) {
    root = new Node();
    for (String word : wordDict) {
      Node node = root;
      for (char c : word.toCharArray()) {
        if (!node.next.containsKey(c)) {
          Node cNode = new Node();
          node.next.put(c, cNode);
          node = cNode;
        } else {
          node = node.next.get(c);
        }
      }
      node.isWord = true;
    }
  }


  public boolean wordBreak(String s, List<String> wordDict) {
    memo = new int[s.length() + 1];
    buildPrefixTree(wordDict);
    char[] chars = s.toCharArray();
    return search(0, chars);
  }

  private boolean search(int start, char[] chars) {
    if (start == chars.length) {
      return true;
    }

    Node node = root;
    for (int i = start; i < chars.length; i++) {
      if (memo[start] == 1) {
        //System.out.println(new String(chars,start,chars.length-start));
        return false;
      }
      if (node.next.containsKey(chars[i])) {
        Node cNode = node.next.get(chars[i]);
        if (cNode.isWord) {
          if (search(i + 1, chars)) {
            return true;
          } else {
            memo[i + 1] = 1;
            node = cNode;
          }
        } else {
          node = cNode;
        }
      } else {
        return false;
      }
    }

    return false;
  }

  public static void main(String[] args) {
    WordBreak wordBreak = new WordBreak();
    boolean b = wordBreak.wordBreak("aaaaaaaaaaaab", Arrays.asList("a", "aa", "aaa", "aaaa","aaaaa"));
    System.out.println(b);
  }

}
