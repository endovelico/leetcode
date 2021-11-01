package solutions.p997;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int findJudge(int town_population, int[][] trust_relationships) {

        // Each index is person#i the value being its trust count.
        int[] trusted_array = new int[town_population];

        // Unique set of trustees, we need this because Judge can not be in here.
        Set<Integer> voter_set = new HashSet<Integer>();

        for ( int i = 0; i < trust_relationships.length; i++) {
            int trusted_id = trust_relationships[i][1];
            trusted_array[trusted_id - 1]++;
            voter_set.add(trust_relationships[i][0]);
        }

        for (int trusted_townsperson = 0; trusted_townsperson < trusted_array.length; trusted_townsperson++) {
            if( trusted_array[trusted_townsperson] == town_population - 1
                    && !voter_set.contains(trusted_townsperson + 1) ) return trusted_townsperson + 1;
        }

        return -1;
    }
}
