package solutions.p131;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<List<String>> partition(String s) {

        List<List<String>> result_list = new ArrayList<List<String>>();
        backtracking_partition(0, s, new ArrayList<>(), result_list);
        return result_list;
    }

    private void backtracking_partition(int index, String str, ArrayList<String> current_list, List<List<String>> result_list) {

        // Base case


        // for
            // add element
            // remove, unwind

    }

}