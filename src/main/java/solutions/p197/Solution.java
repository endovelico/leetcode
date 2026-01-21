package solutions.p197;

public class Solution {

    public void runQuery() {
        String sql = "SELECT w1.id\n" +
                "FROM Weather w1\n" +
                "JOIN Weather w2\n" +
                "  ON w1.recordDate = DATE_ADD(w2.recordDate, INTERVAL 1 DAY)\n" +
                "WHERE w1.temperature > w2.temperature;\n";
    }
}
