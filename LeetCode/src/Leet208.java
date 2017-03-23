/**
 * Created by sail on 9/20/16.
 * Code one more line :)
 */
class TrieNode {
    // Initialize your data structure here.
    boolean isWord;
    TrieNode[] child;
    TrieNode() {
        child = new TrieNode[26];
    }
}

public class Leet208 {
    private TrieNode root;

    public Leet208() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if (word == null || word.length() == 0) return ;
        TrieNode cur = root;
        char[] ch = word.toCharArray();
        for (char s : ch) {
            if (cur.child[s - 'a'] == null)
                cur.child[s - 'a'] = new TrieNode();
            cur = cur.child[s - 'a'];
        }
        cur.isWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode ans = find(word);
        return ans != null && ans.isWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return find(prefix) != null;
    }

    private TrieNode find(String target) {
        if (target == null || target.length() == 0) return null;
        TrieNode cur = root;
        char[] ch = target.toCharArray();
        for (int i = 0; i < ch.length && cur != null; i++) {
            cur = cur.child[ch[i] - 'a'];
        }
        return cur;
    }
}
