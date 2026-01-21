package solutions.p589;

import common.Node;

import java.util.ArrayList;
import java.util.List;

class Solution {


    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }

    private void dfs(Node node, List<Integer> result) {
        if (node == null) return;

        result.add(node.val);          // PREORDER: visit first
        for (Node child : node.children) {
            dfs(child, result);
        }
    }
}