package solutions.p509;

import markdown.MarkdownUtils;

import java.util.HashMap;
import java.util.Map;

public class MemoizedSolution {
    private static Map<Integer, Integer> memo = new HashMap<>();

    public static int fib(int n) {
        if (n <= 1) return n;

        if (memo.containsKey(n)) return memo.get(n);

        int result = fib(n - 1) + fib(n - 2);
        memo.put(n, result); // cache the result
        return result;
    }

    public static void main(String[] args) {

        MarkdownUtils.printMarkdownToConsole("\"Time: O(n) — each fib(i) computed once\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"Space: O(n) — memoization map + recursion stack\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"✅ Efficient and easy to write, slightly slower than tabulation for large n due to recursion overhead\\n\" +\n" +
                "                \"\\n\"");
    }
}
