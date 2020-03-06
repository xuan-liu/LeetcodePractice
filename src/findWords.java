import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class findWords {
    static class TrieNode{
        TrieNode[] next = new TrieNode[26];
        String word;
    }

    public static List<String> solution(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs (board, i, j, root, res);
            }
        }
        return res;
    }

    /* start the trie at board[i][j], if we can find a word, add it to res */
    private static void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
        char c = board[i][j];
        if (c == '#' || p.next[c - 'a'] == null) {
            return;
        }
        p = p.next[c - 'a'];
        if (p.word != null) {
            // it means we found a word
            res.add(p.word);
            p.word = null; // de-duplicate
        }

        board[i][j] = '#';
        if (i > 0) {
            dfs(board, i - 1, j, p, res);
        }
        if (j > 0) {
            dfs(board, i, j - 1, p, res);
        }
        if (i < board.length - 1) {
            dfs(board, i + 1, j, p, res);
        }
        if (j < board[0].length - 1) {
            dfs(board, i, j + 1, p, res);
        }
        board[i][j] = c;
    }

    /* use the words array to build a trie, if it's the end of the trie, let word be that word */
    private static TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w: words) {
            TrieNode p = root;
            for (char c: w.toCharArray()) {
                int i = c - 'a';
                if (p.next[i] == null) {
                    p.next[i] = new TrieNode();
                }
                p = p.next[i];
            }
            p.word = w;
        }
        return root;
    }





    /* ------------------------------------------------------------------------------------ */
    public static List<String> mySolution(char[][] board, String[] words) {
        List<String> res = new LinkedList<>();
        for (String w: words) {
            if (existWord(board, w)) {
                res.add(w);
            }
        }
        return res;
    }

    /* check whether one word can be found in the board */
    private static boolean existWord(char[][] board, String word) {
        char[] w = word.toCharArray();

        // check each cell for exist
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (exist(board, i, j, w, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* check board[x][y] will be the start cell of the word */
    private static boolean exist(char[][] board, int x, int y, char[] w, int start) {
        // if we iterate over the last char of w, then return true
        if (start == w.length) {
            return true;
        }
        // if the cell is out of boundary, then return false
        if (x < 0 || y < 0 || x == board.length || y == board[0].length) {
            return false;
        }
        // if the value of the cell not equals to the char of w, then return false
        if (board[x][y] != w[start]) {
            return false;
        }
        // mask the cell by XOR with 100000000
        board[x][y] ^= 256;
        boolean exist = (exist(board, x + 1, y, w, start + 1) || exist(board, x - 1, y, w, start + 1)
                || exist(board, x, y + 1, w, start + 1) || exist(board, x, y - 1, w, start + 1));

        board[x][y] ^= 256;
        return exist;
    }

    public static void main(String[] args) {
        char[][] input = new char[][]{{'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}};
        String[] words = new String[]{"oath","pea","eat","rain"};
        System.out.println(solution(input, words));
    }
}
