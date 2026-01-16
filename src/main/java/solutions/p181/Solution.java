package solutions.p181;

public class Solution {

    public void runQuery() {
        String sql = "SELECT e.name AS Employee\n" +
                "FROM Employee e\n" +
                "JOIN Employee m ON e.managerId = m.id\n" +
                "WHERE e.salary > m.salary;\n";
    }
}