package solutions.p100;

import common.TreeNode;

public class Solution {
    public boolean isSameTree(TreeNode first_tree, TreeNode second_tree) {

        if( first_tree == null && second_tree == null) return true;
        if( first_tree == null || second_tree == null) return false;
        if( first_tree.val != second_tree.val ) return false;

        return isSameTree( first_tree.left, second_tree.left )
                && isSameTree( first_tree.right, second_tree.right );
    }
}
