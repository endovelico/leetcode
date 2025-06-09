package solutions.p509;

import markdown.MarkdownUtils;

public class TabulatedSolution {
    public static int fib(int n) {
        if (n <= 1) return n;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static void main(String[] args) {

        MarkdownUtils.printMarkdownToConsole("**Memoization** and **Tabulation** are two techniques to optimize recursive algorithms, especially **Dynamic Programming** problems.\n" +
                "\n" +
                "---\n" +
                "\n" +
                "### ✅ Memoization (Top-Down)\n" +
                "\n" +
                "* **Definition**: You solve the problem recursively and **store the result** of each subproblem in a data structure (like a `Map` or array) so you don’t compute it again.\n" +
                "* **Approach**: Recursive + Caching\n" +
                "\n" +
                "#### Java Example: Fibonacci with Memoization\n" +
                "\n" +
                "```java\n" +
                "import java.util.HashMap;\n" +
                "import java.util.Map;\n" +
                "\n" +
                "public class MemoizedFibonacci {\n" +
                "    private static Map<Integer, Integer> memo = new HashMap<>();\n" +
                "\n" +
                "    public static int fib(int n) {\n" +
                "        if (n <= 1) return n;\n" +
                "\n" +
                "        if (memo.containsKey(n)) return memo.get(n);\n" +
                "\n" +
                "        int result = fib(n - 1) + fib(n - 2);\n" +
                "        memo.put(n, result); // cache the result\n" +
                "        return result;\n" +
                "    }\n" +
                "\n" +
                "    public static void main(String[] args) {\n" +
                "        System.out.println(fib(10)); // Output: 55\n" +
                "    }\n" +
                "}\n" +
                "```\n" +
                "\n" +
                "---\n" +
                "\n" +
                "### ✅ Tabulation (Bottom-Up)\n" +
                "\n" +
                "* **Definition**: You build the solution from the **base cases up**, storing results in a table (usually an array).\n" +
                "* **Approach**: Iterative + Table filling\n" +
                "\n" +
                "#### Java Example: Fibonacci with Tabulation\n" +
                "\n" +
                "```java\n" +
                "public class TabulatedFibonacci {\n" +
                "    public static int fib(int n) {\n" +
                "        if (n <= 1) return n;\n" +
                "\n" +
                "        int[] dp = new int[n + 1];\n" +
                "        dp[0] = 0;\n" +
                "        dp[1] = 1;\n" +
                "\n" +
                "        for (int i = 2; i <= n; i++) {\n" +
                "            dp[i] = dp[i - 1] + dp[i - 2];\n" +
                "        }\n" +
                "\n" +
                "        return dp[n];\n" +
                "    }\n" +
                "\n" +
                "    public static void main(String[] args) {\n" +
                "        System.out.println(fib(10)); // Output: 55\n" +
                "    }\n" +
                "}\n" +
                "```\n" +
                "\n" +
                "---\n" +
                "\n" +
                "### \uD83D\uDD01 Comparison Summary\n" +
                "\n" +
                "| Feature          | Memoization                    | Tabulation                    |\n" +
                "| ---------------- | ------------------------------ | ----------------------------- |\n" +
                "| Strategy         | Top-down (recursive)           | Bottom-up (iterative)         |\n" +
                "| Data structure   | HashMap or array               | Array                         |\n" +
                "| Call stack usage | Can be deep (risk of overflow) | Controlled, minimal stack     |\n" +
                "| Speed            | Fast after caching             | Often faster due to iteration |\n" +
                "| Code style       | Closer to naive recursion      | More manual but predictable   |\n" +
                "\n" +
                "---\n" +
                "\n" +
                "Would you like implementations for a more complex problem (e.g., 0/1 Knapsack, LCS, etc.) using both techniques?\n");
    }
}