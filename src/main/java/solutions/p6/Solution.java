package solutions.p6;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public String convert(String to_convert, int number_of_rows) {

        if (number_of_rows == 1) return to_convert;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(number_of_rows, to_convert.length()); i++)
            rows.add(new StringBuilder());

        int current_row = 0;
        boolean goingDown = false;

        for (char c : to_convert.toCharArray()) {
            rows.get(current_row).append(c);
            if (current_row == 0 || current_row == number_of_rows - 1) goingDown = !goingDown;
            current_row += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }
}