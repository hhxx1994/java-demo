package leetcode;

/**
 * @author huanghaoxing
 * 208. 实现 Trie (前缀树)
 */
public class Trie {
    TrieNode root;

    static class TrieNode {
        char c;
        boolean isEnd;
        int count;
        TrieNode[] child;

        public TrieNode() {
            child = new TrieNode[26];
        }
    }

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.child[index] == null) {
                TrieNode trieNode = new TrieNode();
                node.child[index] = trieNode;
                trieNode.c = word.charAt(i);
            }
            node = node.child[index];
            node.count++;
        }
        node.isEnd = true;

    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        if (node == null) {
            return false;
        }
        return node.isEnd;
    }

    public TrieNode searchPrefix(String word) {
        if (word == null || word.length() == 0) {
            return null;
        }
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.child[index] == null) {
                return null;
            }
            node = node.child[index];
        }
        return node;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;

    }

    public void delete(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        if (search(word)) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (node.child[index].count == 1) {
                    node.child[index] = null;
                    return;
                } else {
                    node.child[index].count--;
                }
                node = node.child[index];
            }
            node.isEnd = false;

        }

    }
}
