public class Trie {
    // define the TrieNode
    class TrieNode{
        char val;
        boolean isWord;
        TrieNode[] children = new TrieNode[26];

        TrieNode(){};
        TrieNode(char c) {
            TrieNode node = new TrieNode();
            node.val = c;
        }
    }

    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
        root.val = ' ';
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;

        // for each char in the word, add to the TrieNode
        for (char c: word.toCharArray()) {
            // if there are no such child, then we add it
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode(c);
            }
            // move the node to next layer
            node = node.children[c - 'a'];

        }
        // mark the isWord
        node.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;

        // for each char in the word, search in the TrieNode
        for (char c: word.toCharArray()) {
            // if we can not find the child, then return false
            if (node.children[c - 'a'] == null) {
                return false;
            }
            // move the node to next layer
            node = node.children[c - 'a'];
        }
        // if we iterate to the last, check isWord
        return node.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;

        // for each char in the prefix, search in the TrieNode
        for (char c: prefix.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                return false;
            }
            // move the node to next layer
            node = node.children[c - 'a'];
        }
        // if we iterate to the last, return true
        return true;
    }
}
