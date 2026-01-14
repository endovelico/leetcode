package solutions.p175;

import org.codehaus.plexus.component.annotations.Component;

import java.util.List;
import java.util.Map;

public class Solution {


    public void runQuery() {
        String sql = "SELECT\n" +
                "    p.firstName,\n" +
                "    p.lastName,\n" +
                "    a.city,\n" +
                "    a.state\n" +
                "FROM Person p\n" +
                "LEFT JOIN Address a\n" +
                "    ON p.personId = a.personId;"; // example table
    }
}