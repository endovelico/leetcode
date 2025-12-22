package solutions.p231;

import markdown.MarkdownUtils;

public class Solution {

    public boolean BitManipulationSolution(int n) {

        // Step 1: Powers of two must be positive
        if (n <= 0) {
            return false;
        }

        // Step 2: Check if only one bit is set
        return (n & (n - 1)) == 0;
    }


    public boolean KeepDividingSolution(int n) {

        if (n <= 0) return false;
        while (n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }


    public boolean CountBits(int n) {
        return n > 0 && Integer.bitCount(n) == 1;

    }

    public static void main(String[] args) {

        MarkdownUtils.printMarkdownToConsole("Here are some **clear tips and common approaches** to solve the **LeetCode “Power of Two”** problem (Problem #231): you need to return `true` if a given integer `n` is a power of two (i.e., `n == 2^x` for some integer `x`), otherwise `false`. ([LeetCode][1])\n" +
                "\n" +
                "---\n" +
                "\n" +
                "## \uD83E\uDDE0 Key Idea\n" +
                "\n" +
                "A number is a **power of two** **if and only if**:\n" +
                "\n" +
                "* It is **greater than 0** (powers of two are positive), and\n" +
                "* It has **exactly one bit** set in its **binary representation**. ([AlgoMonster][2])\n" +
                "\n" +
                "Example:\n" +
                "\n" +
                "```\n" +
                "1 → 0001\n" +
                "2 → 0010\n" +
                "4 → 0100\n" +
                "8 → 1000\n" +
                "16 → 10000\n" +
                "```\n" +
                "\n" +
                "---\n" +
                "\n" +
                "## ✅ Best Tips & Methods\n" +
                "\n" +
                "### ✅ **1. Bit Manipulation (Optimal — O(1) time)**\n" +
                "\n" +
                "This is the most common and recommended solution.\n" +
                "\n" +
                "**Insight:**\n" +
                "For any positive power of two, only one bit is `1`.\n" +
                "If you compute **`n & (n - 1)`**, that will **remove the lowest set bit**. If the result is `0`, then `n` only had one set bit → it *was* a power of two. ([AlgoMonster][2])\n" +
                "\n" +
                "**Checklist**\n" +
                "\n" +
                "1. Check if `n > 0`\n" +
                "2. Compute `n & (n - 1)`\n" +
                "3. If that equals `0`, it’s a power of two\n" +
                "\n" +
                "**Example in Python**\n" +
                "\n" +
                "```python\n" +
                "class Solution:\n" +
                "    def isPowerOfTwo(self, n: int) -> bool:\n" +
                "        return n > 0 and (n & (n - 1)) == 0\n" +
                "```\n" +
                "\n" +
                "**Why it works:**\n" +
                "\n" +
                "* `n = 8` → `1000`\n" +
                "* `n – 1 = 7` → `0111`\n" +
                "* `1000 & 0111 == 0000` → power of two! ([AlgoMonster][2])\n" +
                "\n" +
                "---\n" +
                "\n" +
                "### \uD83D\uDD04 **2. Repeated Division (Simple — O(log n))**\n" +
                "\n" +
                "Keep dividing by 2 while the number is even.\n" +
                "\n" +
                "**Steps**\n" +
                "\n" +
                "1. If `n <= 0` → return `false`\n" +
                "2. While `n % 2 == 0`, divide: `n /= 2`\n" +
                "3. If you reach `n == 1`, it’s a power of two\n" +
                "\n" +
                "**Example**\n" +
                "\n" +
                "```java\n" +
                "public boolean isPowerOfTwo(int n) {\n" +
                "    if (n <= 0) return false;\n" +
                "    while (n % 2 == 0) {\n" +
                "        n /= 2;\n" +
                "    }\n" +
                "    return n == 1;\n" +
                "}\n" +
                "```\n" +
                "\n" +
                "This works, but it’s slower than the bit trick for very large numbers. ([Medium][3])\n" +
                "\n" +
                "---\n" +
                "\n" +
                "### \uD83E\uDDEE **3. Count Bits**\n" +
                "\n" +
                "Another way is to count the number of `1`s in the binary representation. If it’s exactly one, it’s a power of two.\n" +
                "\n" +
                "**Example (Java)**\n" +
                "\n" +
                "```java\n" +
                "return n > 0 && Integer.bitCount(n) == 1;\n" +
                "```\n" +
                "\n" +
                "Most languages have built-ins for counting bits (e.g., `Integer.bitCount` in Java or `n.bit_count()` in Python). ([walkccc.me][4])\n" +
                "\n" +
                "---\n" +
                "\n" +
                "## \uD83E\uDDEA **Important Edge Cases**\n" +
                "\n" +
                "✔ `n = 0` → **false** (0 is not a power of two)\n" +
                "✔ Negative numbers → **false**\n" +
                "✔ Large powers of two like `2^30` should still return **true**\n" +
                "✔ Numbers like `3`, `5`, `6` → **false** ([Design Gurus][5])\n" +
                "\n" +
                "---\n" +
                "\n" +
                "## \uD83D\uDD0D Recommended Approach\n" +
                "\n" +
                "\uD83D\uDC49 Use **bit manipulation** (`n > 0 && (n & (n-1)) == 0`) — it’s clean, fast, and elegant. ([AlgoMonster][2])\n" +
                "\n" +
                "---\n" +
                "\n" +
                "If you want, I can walk you through **why the bit trick works** step-by-step with visuals or explain **alternate ways to think about this in recursion or math**!\n" +
                "\n" +
                "[1]: https://leetcode.com/problems/power-of-two/?utm_source=chatgpt.com \"Power of Two\"\n" +
                "[2]: https://algo.monster/liteproblems/231?utm_source=chatgpt.com \"231. Power of Two - In-Depth Explanation\"\n" +
                "[3]: https://medium.com/%40jaydeepdnai.imscit20/leetcode-power-of-two-lets-crack-google-44d920ea07e4?utm_source=chatgpt.com \"LeetCode: Power of Two | Let's Crack Google\"\n" +
                "[4]: https://walkccc.me/LeetCode/problems/231/?utm_source=chatgpt.com \"231. Power of Two - LeetCode Solutions\"\n" +
                "[5]: https://www.designgurus.io/answers/detail/231-power-of-two-2pow?utm_source=chatgpt.com \"231. Power of Two - Detailed Explanation\"\n");

    }

}
