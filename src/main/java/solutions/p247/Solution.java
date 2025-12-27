package solutions.p247;

import markdown.MarkdownUtils;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<String> findStrobogrammatic(int n) {
        return build(n, n);
    }

    private List<String> build(int remaining, int totalLength) {

        if (remaining == 0 ) return List.of("");
        if (remaining == 1 ) return List.of("0", "1", "8");

        List<String> middles = build(remaining - 2, totalLength);
        List<String> result = new ArrayList<>();

        for (String middle : middles) {

            // Avoid leading zero at the outermost level
            if (remaining != totalLength) {
                result.add("0" + middle + "0");
            }

            result.add("1" + middle + "1");
            result.add("6" + middle + "9");
            result.add("8" + middle + "8");
            result.add("9" + middle + "6");
        }

        return result;

    }

    public static void main(String[] args) {

        MarkdownUtils.printMarkdownToConsole("Your intuition is **correct**, and also your concern about **time complexity** is exactly why LeetCode 247 (*Strobogrammatic Number II*) is a trap for the “check every number” mindset.\n" +
                "\n" +
                "Let’s straighten the mental model first, then I’ll point you in the *right* direction **without giving you the full solution**.\n" +
                "\n" +
                "---\n" +
                "\n" +
                "## Why your current intuition is the wrong axis \uD83D\uDEAB\n" +
                "\n" +
                "> “Go through each number, and for each digit check if it’s strobogrammatic”\n" +
                "\n" +
                "That approach assumes:\n" +
                "\n" +
                "* You have a **range of numbers** to iterate over\n" +
                "* You’re *filtering* valid ones\n" +
                "\n" +
                "But **this problem is not about checking numbers** — it’s about **constructing** them.\n" +
                "\n" +
                "Key realization:\n" +
                "\n" +
                "> You are **not given numbers**.\n" +
                "> You are asked to **generate all valid strobogrammatic strings of length `n`**.\n" +
                "\n" +
                "There is no upper bound like `10^n` you should iterate through. Doing so would be:\n" +
                "\n" +
                "* Exponential\n" +
                "* Wasteful\n" +
                "* Rejected by time limits\n" +
                "\n" +
                "---\n" +
                "\n" +
                "## Reframe the problem \uD83E\uDDE0\n" +
                "\n" +
                "Instead of asking:\n" +
                "\n" +
                "> “Is this number strobogrammatic?”\n" +
                "\n" +
                "Ask:\n" +
                "\n" +
                "> “How can I *build* only valid strobogrammatic numbers?”\n" +
                "\n" +
                "That shift kills the `O(n²)` (and worse) idea entirely.\n" +
                "\n" +
                "---\n" +
                "\n" +
                "## Core insight (this is the unlock \uD83D\uDD11)\n" +
                "\n" +
                "Strobogrammatic numbers have a **mirror structure**.\n" +
                "\n" +
                "Valid digit pairs:\n" +
                "\n" +
                "```\n" +
                "('0','0')\n" +
                "('1','1')\n" +
                "('8','8')\n" +
                "('6','9')\n" +
                "('9','6')\n" +
                "```\n" +
                "\n" +
                "Meaning:\n" +
                "\n" +
                "* The **first and last** digits are linked\n" +
                "* Same for the second and second-last\n" +
                "* You never decide digits independently\n" +
                "\n" +
                "This screams:\n" +
                "\n" +
                "> **Build from the outside → in**\n" +
                "\n" +
                "---\n" +
                "\n" +
                "## Think recursively (but carefully)\n" +
                "\n" +
                "Imagine this thought experiment:\n" +
                "\n" +
                "### What are all strobogrammatic numbers of length 0?\n" +
                "\n" +
                "* `[\"\"]` (empty string — base for building)\n" +
                "\n" +
                "### Length 1?\n" +
                "\n" +
                "* `[\"0\", \"1\", \"8\"]` (center digits only)\n" +
                "\n" +
                "### Length 2?\n" +
                "\n" +
                "* Wrap pairs around `\"\"`\n" +
                "* But **leading zero is NOT allowed**\n" +
                "\n" +
                "### Length 4?\n" +
                "\n" +
                "* Wrap pairs around length-2 results\n" +
                "\n" +
                "Pattern:\n" +
                "\n" +
                "```\n" +
                "n → take all (n - 2) solutions\n" +
                "     wrap each with valid digit pairs\n" +
                "```\n" +
                "\n" +
                "---\n" +
                "\n" +
                "## Important constraint most people miss ⚠\uFE0F\n" +
                "\n" +
                "> **Leading zeros are illegal**\n" +
                "\n" +
                "So:\n" +
                "\n" +
                "* `\"00\"` ❌\n" +
                "* `\"0110\"` ❌\n" +
                "* `\"0\"` ✅ (only allowed when n == 1)\n" +
                "\n" +
                "This means:\n" +
                "\n" +
                "* `\"0\"` pairs can only be used **when they are not the outermost layer**\n" +
                "\n" +
                "That’s a crucial branching rule.\n" +
                "\n" +
                "---\n" +
                "\n" +
                "## Time complexity reality check \uD83D\uDCC8\n" +
                "\n" +
                "Let:\n" +
                "\n" +
                "* `k` = number of strobogrammatic numbers of length `n`\n" +
                "\n" +
                "Then:\n" +
                "\n" +
                "* Time complexity is **O(k × n)**\n" +
                "  (you must output them, so this is optimal)\n" +
                "\n" +
                "This is **much better** than iterating through all `10^n` numbers.\n" +
                "\n" +
                "---\n" +
                "\n" +
                "## Mental model to keep in your head\n" +
                "\n" +
                "Visualize construction like this:\n" +
                "\n" +
                "```\n" +
                "Level 0: \"\"\n" +
                "Level 1: \"1\" \"8\" \"0\"\n" +
                "Level 2: 11 69 88 96\n" +
                "Level 3: wrap level 1\n" +
                "Level 4: wrap level 2\n" +
                "```\n" +
                "\n" +
                "Always:\n" +
                "\n" +
                "* Outer digits chosen together\n" +
                "* Inner part already valid\n" +
                "\n" +
                "---\n" +
                "\n" +
                "## What NOT to do ❌\n" +
                "\n" +
                "* ❌ Convert integers → strings → check\n" +
                "* ❌ Loop from `10^(n-1)` to `10^n`\n" +
                "* ❌ Nested digit checks\n" +
                "* ❌ Backtracking that checks validity *after* building\n" +
                "\n" +
                "---\n" +
                "\n" +
                "## What you SHOULD be thinking about next ✅\n" +
                "\n" +
                "Before coding, ask yourself:\n" +
                "\n" +
                "1. What is my **base case**?\n" +
                "2. How do I **grow solutions by +2 length**?\n" +
                "3. How do I **forbid leading zeros only at the top level**?\n" +
                "4. How do I handle **odd vs even `n`**?\n" +
                "\n" +
                "If you want, next we can:\n" +
                "\n" +
                "* Walk through **n = 3 step by step**\n" +
                "* Design the recursive signature *together*\n" +
                "* Or translate this into a clean Java approach (without dumping the final code)\n" +
                "\n" +
                "You’re thinking in the right direction — you just need to flip **from filtering to construction**.\n");
    }
}

