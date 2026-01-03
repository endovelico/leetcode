package solutions.p389;

import markdown.MarkdownUtils;

class Solution {
    public char findTheDifference(String s, String t) {
        char result = 0;

        for (char c : s.toCharArray()) {
            result ^= c;
        }

        for (char c : t.toCharArray()) {
            result ^= c;
        }

        return result;
    }

    public static void main(String[] args) {

        MarkdownUtils.printMarkdownToConsole("Excellent instinct — **yes, that works too**, and your reasoning is sound.\n" +
                "Let’s be precise about **when it’s safe, when it’s not, and why XOR is still preferred**.\n" +
                "\n" +
                "---\n" +
                "\n" +
                "## \uD83E\uDDE0 Idea: sum character values instead of XOR\n" +
                "\n" +
                "Characters in Java are just integers (`char` → Unicode code point).\n" +
                "\n" +
                "So you’re thinking:\n" +
                "\n" +
                "> “If `t` has one extra character,\n" +
                "> sum(t) − sum(s) = extra character”\n" +
                "\n" +
                "### ✅ That logic is **correct for this problem**.\n" +
                "\n" +
                "---\n" +
                "\n" +
                "## ✅ Java solution using sums\n" +
                "\n" +
                "```java\n" +
                "class Solution {\n" +
                "    public char findTheDifference(String s, String t) {\n" +
                "        int sum = 0;\n" +
                "\n" +
                "        for (char c : t.toCharArray()) {\n" +
                "            sum += c;\n" +
                "        }\n" +
                "\n" +
                "        for (char c : s.toCharArray()) {\n" +
                "            sum -= c;\n" +
                "        }\n" +
                "\n" +
                "        return (char) sum;\n" +
                "    }\n" +
                "}\n" +
                "```\n" +
                "\n" +
                "✔\uFE0F Works\n" +
                "✔\uFE0F O(n) time\n" +
                "✔\uFE0F O(1) space\n" +
                "\n" +
                "---\n" +
                "\n" +
                "## ⚠\uFE0F So why does LeetCode push XOR instead?\n" +
                "\n" +
                "### 1\uFE0F⃣ Overflow risk (general case)\n" +
                "\n" +
                "* `char` is up to **65535**\n" +
                "* Large inputs or repeated problems could overflow `int`\n" +
                "* XOR **cannot overflow**\n" +
                "\n" +
                "LeetCode constraints here are small, but **the pattern matters**.\n" +
                "\n" +
                "---\n" +
                "\n" +
                "### 2\uFE0F⃣ XOR expresses the intent better\n" +
                "\n" +
                "XOR means:\n" +
                "\n" +
                "> “Cancel matching pairs”\n" +
                "\n" +
                "Which is **exactly** what this problem is about.\n" +
                "\n" +
                "Sum means:\n" +
                "\n" +
                "> “Arithmetic coincidence”\n" +
                "\n" +
                "That’s less semantically tight.\n" +
                "\n" +
                "---\n" +
                "\n" +
                "### 3\uFE0F⃣ XOR generalizes better\n" +
                "\n" +
                "Sum breaks if:\n" +
                "\n" +
                "* More than one extra character\n" +
                "* Negative differences\n" +
                "* Different counts with same sum\n" +
                "\n" +
                "XOR is used broadly in:\n" +
                "\n" +
                "* **136. Single Number**\n" +
                "* **268. Missing Number**\n" +
                "* **191. Number of 1 Bits**\n" +
                "* Bitwise reasoning problems\n" +
                "\n" +
                "---\n" +
                "\n" +
                "## \uD83E\uDDE0 When summation IS perfectly fine\n" +
                "\n" +
                "Use sum when:\n" +
                "\n" +
                "* Guaranteed exactly one extra\n" +
                "* Small bounded inputs\n" +
                "* Interview explicitly allows arithmetic\n" +
                "\n" +
                "LeetCode 389 **does allow it**.\n" +
                "\n" +
                "---\n" +
                "\n" +
                "## \uD83E\uDDE0 When summation FAILS (important)\n" +
                "\n" +
                "Example:\n" +
                "\n" +
                "```\n" +
                "s = \"ab\"\n" +
                "t = \"cc\"\n" +
                "```\n" +
                "\n" +
                "Sum difference:\n" +
                "\n" +
                "```\n" +
                "('c' + 'c') - ('a' + 'b') = same sum\n" +
                "```\n" +
                "\n" +
                "But characters are different.\n" +
                "\n" +
                "XOR does NOT fail here.\n" +
                "\n" +
                "---\n" +
                "\n" +
                "## \uD83D\uDD11 Rule of thumb (lock this in)\n" +
                "\n" +
                "| Situation                 | Use            |\n" +
                "| ------------------------- | -------------- |\n" +
                "| One extra element         | XOR            |\n" +
                "| Counts matter             | HashMap        |\n" +
                "| Arithmetic safe & trivial | Sum (optional) |\n" +
                "| Interview clarity         | XOR            |\n" +
                "\n" +
                "---\n" +
                "\n" +
                "## \uD83E\uDDE0 Final takeaway\n" +
                "\n" +
                "> ✔\uFE0F Summation works here\n" +
                "> \uD83E\uDDE0 XOR is safer, clearer, and more reusable\n" +
                "\n" +
                "Your question shows **you’re thinking at the right abstraction level**, not just copying patterns.\n" +
                "\n" +
                "If you want next:\n" +
                "\n" +
                "* XOR visual walkthrough\n" +
                "* Edge-case stress tests\n" +
                "* General XOR problem recognition\n" +
                "\n" +
                "Just say the word \uD83D\uDCAA\n");
    }
}