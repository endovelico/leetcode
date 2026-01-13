package common;

public class TrieNode {

    private static final int NUMBER_OF_LETTERS = 26;

    public TrieNode[] children_nodes = new TrieNode[NUMBER_OF_LETTERS];
    public boolean is_end_of_word = false;
}
