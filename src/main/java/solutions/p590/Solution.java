package solutions.p590;

import common.Node;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<Integer> postorder(Node root) {
;
        List<Integer> result_array = new ArrayList<>();
        postorder_transversal(root, result_array);

        return result_array;
    }

    private void postorder_transversal(Node root, List<Integer> result_array) {

        if(root == null) return;

        for (Node child : root.children) {
            postorder_transversal(child, result_array);
        }

        result_array.add(root.val);

    }
}