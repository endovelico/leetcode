package common;

public class TrieNode {

    private static final int NUMBER_OF_LETTERS = 26;

    TrieNode[] children_nodes = new TrieNode[NUMBER_OF_LETTERS];
    boolean isFinal = false;
}
