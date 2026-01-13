package solutions.p1356;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public int[] sortByBits(int[] arr) {

        Integer[] boxed = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        Arrays.sort(boxed, (a, b) -> {
            int difference = bitCounter(a) - bitCounter(b);

            if(difference == 0) return a - b;
            return difference;
        });


        return Arrays.stream(boxed)
                .mapToInt(Integer::intValue)
                .toArray();

    }

    public int bitCounter(int number) {
        int counter = 0;
        while (number > 0) {
            counter += (number & 1);
            number >>= 1;
        }
        return counter;
    }

}
