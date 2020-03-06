import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class palindromePairs {
    private static class TrieNode {
        TrieNode[] next; // hashtable for the next letter
        int index; // the index of the word in the array
        List<Integer> list;
        // indices of all words satisfying: each word has a suffix represented by the current TrieNode;
        // the rest of the word forms a palindrome

        TrieNode() {
            next = new TrieNode[26];
            index = -1;
            list = new ArrayList<>();
        }
    }

    public static List<List<Integer>> mySolution(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        TrieNode root = new TrieNode();

        for (int i = 0; i < words.length; i++) {
            addWord(root, words[i], i);
        }

        for (int i = 0; i < words.length; i++) {
            search(words, i, root, res);
        }

        return res;
    }

    private static void search(String[] words, int i, TrieNode root, List<List<Integer>> res) {
        for (int j = 0; j < words[i].length(); j++) {
            // case1: the reverse of s2 is a suffix of s1 and the rest part of s1 is a palindrome
            // eg, i = s1 = "bacac", root.index's content = s2 = "ab", then (s1, s2) is palindrome
            if (root.index >= 0 && root.index != i && isPalindrome(words[i], j, words[i].length() - 1)) {
                res.add(Arrays.asList(j, root.index));
            }

            root = root.next[words[i].charAt(j) - 'a'];
            if (root == null) {
                return;
            }
        }

        // case2: the reverse of s1 is a suffix of s2 and the rest part of s2 is a palindrome
        // eg, i = s1 = "ab", root.list has s2 = "cacba", then (s1, s2) is palindrome
        for (int j: root.list) {
            if (i == j){
                continue;
            }
            res.add(Arrays.asList(i, j));
        }
    }

    /* add the word in the root trie */
    private static void addWord(TrieNode root, String word, int index) {
        for (int i = word.length() - 1; i >= 0; i--) {
            int j = word.charAt(i) - 'a';

            // set next
            if (root.next[j] == null) {
                root.next[j] = new TrieNode();
            }

            // set list
            if (isPalindrome(word, 0, i)) {
                root.list.add(index);
            }

            root = root.next[j];
        }
        root.list.add(index);

        // set index
        root.index = index;
    }

    /* tell whether word[i:j] is a palindrome */
    private static boolean isPalindrome(String word, int i, int j) {
        while (i < j) {
            if (word.charAt(i) == word.charAt(j)) {
                i += 1;
                j -= 1;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] s = new String[]{"bat","tab","cat"};
        System.out.println(mySolution(s));
    }
}
