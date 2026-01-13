package solutions.p211;

import common.TrieNode;

class WordDictionary {
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    // Add word to trie normally
    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (node.children_nodes[idx] == null) node.children_nodes[idx] = new TrieNode();
            node = node.children_nodes[idx];
        }
        node.is_end_of_word = true;
    }

    // Search with support for '.'
    public boolean search(String word) {
        return dfs(word.toCharArray(), 0, root);
    }

    private boolean dfs(char[] word, int index, TrieNode node) {
        if (index == word.length) return node.is_end_of_word;

        char c = word[index];
        if (c == '.') {
            for (TrieNode child : node.children_nodes) {
                if (child != null && dfs(word, index + 1, child)) return true;
            }
            return false;
        } else {
            int idx = c - 'a';
            if (node.children_nodes[idx] == null) return false;
            return dfs(word, index + 1, node.children_nodes[idx]);
        }
    }
}