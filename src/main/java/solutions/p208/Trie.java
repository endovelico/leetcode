package solutions.p208;

import common.TrieNode;

class Trie {

    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Insert word into the trie
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';

            if (node.children_nodes[index] == null) {
                node.children_nodes[index] = new TrieNode();
            }
            node = node.children_nodes[index];
        }
        node.is_end_of_word = true;
    }

    // Check if word exactly exists in the trie
    public boolean search(String word) {
        TrieNode node = root;

        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children_nodes[index] == null) {
                return false;
            }
            node = node.children_nodes[index];
        }
        return node.is_end_of_word;
    }

    // Check if any word in the trie starts with the given prefix
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (node.children_nodes[index] == null) {
                return false;
            }
            node = node.children_nodes[index];
        }
        return true;
    }
}
