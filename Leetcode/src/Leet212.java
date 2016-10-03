import java.util.*;

/**
 * Created by sail on 9/20/16.
 * Code one more line :)
 */
public class Leet212 {
    private TrieNode root;
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        if (!preCheck(board, words))
            return ans;
        buildTrie(words);
        findWords(ans, board);
        return ans;
    }
    private boolean preCheck(char[][] board, String[] words) {
        return !(board == null || board.length == 0 || board[0].length == 0 ||
                words == null || words.length == 0);
    }
    private void findWords(List<String> ans, char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(ans, board, i, j, root);
            }
        }
    }
    private void dfs(List<String> ans, char[][] board, int r, int c, TrieNode p) {
        char ch = board[r][c];
        if (ch == '#' || p.child[ch - 'a'] == null) return;
        p = p.child[ch - 'a'];
        if (p.word != null) {
            ans.add(p.word);
            p.word = null;
        }

        board[r][c] = '#';
        if (r > 0) dfs(ans, board, r - 1, c, p);
        if (c > 0) dfs(ans, board, r, c - 1, p);
        if (r < board.length - 1) dfs(ans, board, r + 1, c, p);
        if (c < board[0].length - 1) dfs(ans, board, r, c + 1, p);
        board[r][c] = ch;
    }
    private void buildTrie(String[] words) {
        root = new TrieNode();
        for (String wd: words) {
            insert(wd);
        }
    }
    private void insert(String word) {
        if (word == null || word.length() == 0) return ;
        TrieNode cur = root;
        char[] ch = word.toCharArray();
        for (char s : ch) {
            int i = s - 'a';
            if (cur.child[i] == null)
                cur.child[i] = new TrieNode();
            cur = cur.child[i];
        }
        cur.word = word;
    }
    private class TrieNode {
        String word;
        TrieNode[] child;
        TrieNode() {
            child = new TrieNode[26];
        }
    }
}
