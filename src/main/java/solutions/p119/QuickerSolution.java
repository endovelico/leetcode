package solutions.p119;

import java.util.*;

public class QuickerSolution  {

        public List<Integer> getRow(int rowIndex) {
            List<Integer> row = new ArrayList<>();
            long value = 1; // use long to avoid overflow during computation

            for (int i = 0; i <= rowIndex; i++) {
                row.add((int) value);
                value = value * (rowIndex - i) / (i + 1);
            }

            return row;
        }
    }

