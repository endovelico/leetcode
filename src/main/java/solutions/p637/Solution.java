package solutions.p637;

import common.Node;
import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public List<Double> averageOfLevels(TreeNode root) {

        List<Double> result_list = new ArrayList<>();
        if (root == null) return result_list;

        Queue<TreeNode> current_node_list = new LinkedList<>();
        current_node_list.offer(root);

        while (!current_node_list.isEmpty()) {
            int number_of_nodes = current_node_list.size();
            double current_sum = 0;

            for (int index = 0; index < number_of_nodes; index++) {
                TreeNode current_node = current_node_list.poll();
                current_sum += current_node.val;

                // Only add non-null children
                if (current_node.left != null) current_node_list.offer(current_node.left);
                if (current_node.right != null) current_node_list.offer(current_node.right);
            }

            double result_average = current_sum / number_of_nodes;
            result_list.add(result_average);
        }

        return result_list;
    }
}
