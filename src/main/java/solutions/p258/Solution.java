package solutions.p258;

import markdown.MarkdownUtils;

public class Solution {

    public int addDigits(int num) {

        if (num == 0) return 0;
        return (num - 1) % 9 + 1;
    }

    public int addDigitsNaive(int num) {

        // Repeat until the number is a single digit
        while (num >= 10) {

            int sum = 0;

            // Add digits one by one
            while (num > 0) {
                sum += num % 10; // last digit
                num /= 10;       // remove last digit
            }

            num = sum; // repeat with the new sum
        }

        return num;
    }

    public static void main(String[] args) {

            MarkdownUtils.printMarkdownToConsole("Yes — it **does have a name**, and knowing it is a *big signal* in interviews.\n" +
                    "\n" +
                    "---\n" +
                    "\n" +
                    "## The name of the equation\n" +
                    "\n" +
                    "What you’re using is called the **Digital Root formula**, and it comes from **modular arithmetic (mod 9)**.\n" +
                    "\n" +
                    "Formally, the concept is called:\n" +
                    "\n" +
                    "### **Digital Root**\n" +
                    "\n" +
                    "> The digital root of a non-negative integer is the single-digit value obtained by repeatedly summing its digits.\n" +
                    "\n" +
                    "---\n" +
                    "\n" +
                    "## The exact equation\n" +
                    "\n" +
                    "For base-10 numbers:\n" +
                    "\n" +
                    "```text\n" +
                    "digitalRoot(n) = 0                  if n = 0\n" +
                    "digitalRoot(n) = 1 + (n − 1) mod 9   if n > 0\n" +
                    "```\n" +
                    "\n" +
                    "That `(n − 1) % 9 + 1` is the **closed-form formula** for the digital root.\n" +
                    "\n" +
                    "---\n" +
                    "\n" +
                    "## Where it comes from (the math behind it)\n" +
                    "\n" +
                    "This comes from **modular arithmetic**, specifically **mod 9**, because:\n" +
                    "\n" +
                    "* 10 ≡ 1 (mod 9)\n" +
                    "* 100 ≡ 1 (mod 9)\n" +
                    "* 1000 ≡ 1 (mod 9)\n" +
                    "\n" +
                    "So any number like:\n" +
                    "\n" +
                    "```\n" +
                    "abc = a·100 + b·10 + c\n" +
                    "```\n" +
                    "\n" +
                    "Becomes (mod 9):\n" +
                    "\n" +
                    "```\n" +
                    "a·1 + b·1 + c·1 = a + b + c\n" +
                    "```\n" +
                    "\n" +
                    "➡\uFE0F Summing digits **preserves the value modulo 9**.\n" +
                    "\n" +
                    "Repeating digit sums doesn’t change that remainder — it just shrinks the number.\n" +
                    "\n" +
                    "---\n" +
                    "\n" +
                    "## Why the formula looks “weird”\n" +
                    "\n" +
                    "Why not just `n % 9`?\n" +
                    "\n" +
                    "Because:\n" +
                    "\n" +
                    "| n  | n % 9 | digital root |\n" +
                    "| -- | ----- | ------------ |\n" +
                    "| 9  | 0     | 9            |\n" +
                    "| 18 | 0     | 9            |\n" +
                    "| 27 | 0     | 9            |\n" +
                    "\n" +
                    "So we need to map:\n" +
                    "\n" +
                    "* remainder `0` → `9`\n" +
                    "* remainder `1..8` → `1..8`\n" +
                    "\n" +
                    "That’s exactly what this transformation does:\n" +
                    "\n" +
                    "```text\n" +
                    "(n − 1) % 9 + 1\n" +
                    "```\n" +
                    "\n" +
                    "It shifts the range:\n" +
                    "\n" +
                    "* `% 9` → `0..8`\n" +
                    "* `+1` → `1..9`\n" +
                    "\n" +
                    "---\n" +
                    "\n" +
                    "## Historical / math background (cool to mention)\n" +
                    "\n" +
                    "* Known since **ancient times**\n" +
                    "* Used in:\n" +
                    "\n" +
                    "  * **casting out nines**\n" +
                    "  * error detection in arithmetic\n" +
                    "  * divisibility tests\n" +
                    "* Appears in **number theory**, **modular arithmetic**, and **base-dependent digit systems**\n" +
                    "\n" +
                    "In other bases:\n" +
                    "\n" +
                    "```text\n" +
                    "digitalRoot_base_b(n) = 1 + (n − 1) mod (b − 1)\n" +
                    "```\n" +
                    "\n" +
                    "---\n" +
                    "\n" +
                    "## What to say in an interview (perfect answer)\n" +
                    "\n" +
                    "> “This uses the digital root, which is based on modular arithmetic mod 9. Since summing digits preserves the number modulo 9, we can compute the final single digit in O(1) time using `1 + (n − 1) % 9`, with a special case for zero.”\n" +
                    "\n" +
                    "That’s *exactly* what interviewers want to hear.\n" +
                    "\n" +
                    "---\n" +
                    "\n" +
                    "If you want next, I can:\n" +
                    "\n" +
                    "* formally prove it\n" +
                    "* show why it fails in base-2 or base-16\n" +
                    "* connect it to other LeetCode problems that secretly use digital roots\n" +
                    "\n" +
                    "Just say.\n");
    }
}
