package solutions.p350;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {

    public int[] intersect(int[] nums1, int[] nums2) {

        if( nums1.length > nums2.length) intersect(nums2, nums1);

        HashMap<Integer, Integer> integer_count = new HashMap<Integer, Integer>();
        List<Integer> result_list = new ArrayList<Integer>();

        for(int i = 0; i < nums1.length; i++) {

            integer_count.put( nums1[i], integer_count.getOrDefault( nums1[i], 0 ) + 1 );
        }

        for( int j = 0; j < nums2.length; j++) {

            int hits = integer_count.getOrDefault(nums2[j], 0);

            if( hits > 0) {
                result_list.add(nums2[j]);
                integer_count.put(nums2[j], --hits);
            }


        }


        return result_list.stream().mapToInt(i -> i).toArray();
    }
}