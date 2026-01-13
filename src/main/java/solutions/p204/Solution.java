package solutions.p204;

import markdown.MarkdownUtils;

import java.util.Arrays;

class Solution {
    public int countPrimes(int n) {
        if (n <= 2) return 0;

        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) count++;
        }

        return count;

        // Can also be done
        /*return(int) IntStream.range(2, n)
                .filter(i -> isPrime[i])
                .count();*/
    }

    public static void main(String[] args) {

        MarkdownUtils.printMarkdownToConsole("Let’s analyze it **precisely**, step by step.\n" +
                "\n" +
                "---\n" +
                "\n" +
                "## The algorithm you’re asking about\n" +
                "\n" +
                "This is the **naive approach**:\n" +
                "\n" +
                "```java\n" +
                "int count = 0;\n" +
                "for (int i = 1; i <= n; i++) {\n" +
                "    if (isPrime(i)) {\n" +
                "        count++;\n" +
                "    }\n" +
                "}\n" +
                "```\n" +
                "\n" +
                "Where `isPrime(i)` does trial division:\n" +
                "\n" +
                "```java\n" +
                "boolean isPrime(int x) {\n" +
                "    if (x <= 1) return false;\n" +
                "    for (int d = 2; d * d <= x; d++) {\n" +
                "        if (x % d == 0) return false;\n" +
                "    }\n" +
                "    return true;\n" +
                "}\n" +
                "```\n" +
                "\n" +
                "---\n" +
                "\n" +
                "## Time complexity analysis\n" +
                "\n" +
                "### Cost of `isPrime(x)`\n" +
                "\n" +
                "* Worst case (x is prime): check all divisors up to √x\n" +
                "* Time: **O(√x)**\n" +
                "\n" +
                "---\n" +
                "\n" +
                "### Total cost\n" +
                "\n" +
                "We call `isPrime(i)` for every `i` from `1` to `n`:\n" +
                "\n" +
                "[\n" +
                "\\sum_{i=1}^{n} \\sqrt{i}\n" +
                "]\n" +
                "\n" +
                "This sum behaves like:\n" +
                "\n" +
                "[\n" +
                "\\int_1^n \\sqrt{x} , dx = \\frac{2}{3} n^{3/2}\n" +
                "]\n" +
                "\n" +
                "---\n" +
                "\n" +
                "## ✅ Final time complexity\n" +
                "\n" +
                "[\n" +
                "\\boxed{O(n^{3/2}) = O(n\\sqrt{n})}\n" +
                "]\n" +
                "\n" +
                "---\n" +
                "\n" +
                "## Space complexity\n" +
                "\n" +
                "* Only a few variables\n" +
                "* No extra arrays\n" +
                "\n" +
                "[\n" +
                "\\boxed{O(1)}\n" +
                "]\n" +
                "\n" +
                "---\n" +
                "\n" +
                "## Why this TLEs on LeetCode 204\n" +
                "\n" +
                "Constraints:\n" +
                "\n" +
                "```\n" +
                "n ≤ 5 * 10^6\n" +
                "```\n" +
                "\n" +
                "Plug it in:\n" +
                "\n" +
                "```\n" +
                "n√n ≈ 5e6 × 2236 ≈ 1.1e10 operations\n" +
                "```\n" +
                "\n" +
                "\uD83D\uDC80 Impossible in time.\n" +
                "\n" +
                "---\n" +
                "\n" +
                "## Comparison with sieve\n" +
                "\n" +
                "| Approach              | Time               | Space |\n" +
                "| --------------------- | ------------------ | ----- |\n" +
                "| Check each number     | **O(n√n)**         | O(1)  |\n" +
                "| Sieve of Eratosthenes | **O(n log log n)** | O(n)  |\n" +
                "\n" +
                "This is why **204 exists** — to force the sieve.\n" +
                "\n" +
                "---\n" +
                "\n" +
                "## Key takeaway (memorize this)\n" +
                "\n" +
                "> **Checking each number individually is asymptotically worse than sieving once.**\n" +
                "\n" +
                "---\n" +
                "\n" +
                "If you want next:\n" +
                "\n" +
                "* A **visual comparison** of work done\n" +
                "* How this relates to **amortized analysis**\n" +
                "* Why `log log n` appears in the sieve\n" +
                "* How this compares to a segmented sieve\n" +
                "\n" +
                "Just say which one.\n");
    }
}