package solutions.p575;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int distributeCandies(int[] candies) {
        Set<Integer> uniqueCandies = new HashSet<>();
        for (int candy : candies) {
            uniqueCandies.add(candy);
        }
        return Math.min(uniqueCandies.size(), candies.length / 2);
    }
}