/**
 * Created by sail on 9/21/16.
 * Code one more line :)
 */
public class Leet318 {
    private TrieNode root;
    private int ans = 0;
    public int maxProduct(String[] words) {
        buildTrie(words);
        for (String wd : words) {
            if (wd.equals("")) continue;
//            System.out.println(wd);
            boolean[] vis = new boolean[26];
            for (char c : wd.toCharArray()) {
                vis[c - 'a'] = true;
            }
            dfs(root, wd.length(), vis);
        }
        return ans;
    }
    private void dfs(TrieNode curNode, int pre, boolean[] vis) {
        if (curNode.word != null) {
//            System.out.println("===== " + curNode.word);
//            System.out.println(curNode.word.length() + " " + pre);
            ans = Math.max(ans, curNode.word.length() * pre);
        }
        for (int i = 0; i < 26; i++) {
            if (curNode.child[i] != null && !vis[i]) {
//                System.out.println("i: " + (char)(i + 'a'));
                dfs(curNode.child[i], pre, vis);
            }
        }
    }

    private class TrieNode {
        TrieNode[] child = new TrieNode[26];
        String word;
    }
    private void buildTrie(String[] words) {
        root = new TrieNode();
        for (String wd : words) {
            if (wd.equals("")) continue;
            TrieNode cur = root;
            char[] ch = wd.toCharArray();
            for (char c : ch) {
                int i = c - 'a';
                if (cur.child[i] == null)
                    cur.child[i] = new TrieNode();
                cur = cur.child[i];
            }
            cur.word = wd;
        }
    }

    public void run() {
        String[] str = new String[]{"a", "aa", "aaa", "aaaa"};
        int ans = maxProduct(str);
        System.out.println(ans);
    }
    public static void main(String[] args) {
        new Leet318().run();
    }
}
