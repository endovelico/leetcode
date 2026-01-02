package solutions.p119;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();

        for (int row_index = 0; row_index <= rowIndex; row_index++) {
            // Add a trailing 1
            row.add(1);

            // Update from right to left
            for (int column_index = row_index - 1; column_index > 0; column_index--) {
                row.set(column_index, row.get(column_index) + row.get(column_index - 1));
            }
        }

        return row;
    }
}
