package solutions.p292;

import markdown.MarkdownUtils;

public class Solution {

    public boolean canWinNim(int n) {

        return n % 4 != 0;
    }


    public static void main(String[] args) {

        MarkdownUtils.printMarkdownToConsole("That’s totally fair — this line feels like **black magic** until the mental model clicks.\n" +
                "Let’s slow it down and rebuild it from first principles, **no hand-waving**.\n" +
                "\n" +
                "---\n" +
                "\n" +
                "## Step 1: Forget code. Think in *positions*.\n" +
                "\n" +
                "You’re not deciding *what move to play*.\n" +
                "You’re deciding whether the **current position** is:\n" +
                "\n" +
                "* ✅ **Winning** (you can force a win)\n" +
                "* ❌ **Losing** (you lose if the opponent plays optimally)\n" +
                "\n" +
                "---\n" +
                "\n" +
                "## Step 2: Define what “winning” and “losing” mean\n" +
                "\n" +
                "* **Winning position**:\n" +
                "  There exists **at least one move** that puts your opponent into a losing position.\n" +
                "\n" +
                "* **Losing position**:\n" +
                "  **All possible moves** put your opponent into winning positions.\n" +
                "\n" +
                "This definition is everything.\n" +
                "\n" +
                "---\n" +
                "\n" +
                "## Step 3: Build the truth table (manually)\n" +
                "\n" +
                "Let’s label:\n" +
                "\n" +
                "* **W** = winning position\n" +
                "* **L** = losing position\n" +
                "\n" +
                "You can remove **1, 2, or 3 stones**.\n" +
                "\n" +
                "| Stones (n) | Possible moves | Result |\n" +
                "| ---------- | -------------- | ------ |\n" +
                "| 1          | → 0            | W      |\n" +
                "| 2          | → 1, 0         | W      |\n" +
                "| 3          | → 2, 1, 0      | W      |\n" +
                "| 4          | → 3, 2, 1      | **L**  |\n" +
                "| 5          | → 4, 3, 2      | W      |\n" +
                "| 6          | → 5, 4, 3      | W      |\n" +
                "| 7          | → 6, 5, 4      | W      |\n" +
                "| 8          | → 7, 6, 5      | **L**  |\n" +
                "| 9          | → 8, 7, 6      | W      |\n" +
                "\n" +
                "**Why is 4 losing?**\n" +
                "Because every move gives the opponent 1, 2, or 3 — all winning.\n" +
                "\n" +
                "**Why is 5 winning?**\n" +
                "Because you can move to 4.\n" +
                "\n" +
                "---\n" +
                "\n" +
                "## Step 4: See the invariant (this is the “aha”)\n" +
                "\n" +
                "Look only at losing positions:\n" +
                "\n" +
                "```\n" +
                "4, 8, 12, 16, ...\n" +
                "```\n" +
                "\n" +
                "That’s:\n" +
                "\n" +
                "```\n" +
                "n % 4 == 0\n" +
                "```\n" +
                "\n" +
                "Every other number can **jump to** a multiple of 4.\n" +
                "\n" +
                "---\n" +
                "\n" +
                "## Step 5: Why multiples of 4 are doomed\n" +
                "\n" +
                "If you start your turn on `4k` stones:\n" +
                "\n" +
                "* You remove 1 → opponent gets `4k - 1`\n" +
                "* You remove 2 → opponent gets `4k - 2`\n" +
                "* You remove 3 → opponent gets `4k - 3`\n" +
                "\n" +
                "On their turn, they remove stones to give **you back `4(k-1)`**.\n" +
                "\n" +
                "They always restore the multiple of 4.\n" +
                "\n" +
                "You are **forced** into:\n" +
                "\n" +
                "```\n" +
                "4 → 0\n" +
                "8 → 4 → 0\n" +
                "12 → 8 → 4 → 0\n" +
                "```\n" +
                "\n" +
                "You never get control again.\n" +
                "\n" +
                "---\n" +
                "\n" +
                "## Step 6: Translate logic → code\n" +
                "\n" +
                "Now the code makes sense:\n" +
                "\n" +
                "```java\n" +
                "public boolean canWinNim(int n) {\n" +
                "    return n % 4 != 0;\n" +
                "}\n" +
                "```\n" +
                "\n" +
                "### Read it in English:\n" +
                "\n" +
                "> “If the number of stones is **not** a multiple of 4, the current player can force a win.”\n" +
                "\n" +
                "---\n" +
                "\n" +
                "## Step 7: Why nothing else is needed\n" +
                "\n" +
                "* No loops\n" +
                "* No recursion\n" +
                "* No simulation\n" +
                "* No guessing\n" +
                "\n" +
                "Because:\n" +
                "\n" +
                "* Optimal play removes uncertainty\n" +
                "* The game collapses into a **modulo invariant**\n" +
                "\n" +
                "---\n" +
                "\n" +
                "## One last intuition (very important)\n" +
                "\n" +
                "Think of it like this:\n" +
                "\n" +
                "> The *goal* of Nim is not to take stones\n" +
                "> The goal is to **hand your opponent multiples of 4**\n" +
                "\n" +
                "Once you see that, the solution is unavoidable.\n" +
                "\n" +
                "---\n" +
                "\n" +
                "If you want, next we can:\n" +
                "\n" +
                "* Draw this as a **state diagram**\n" +
                "* Generalize to “remove up to k stones”\n" +
                "* Show how this shows up in **real interview problems**\n" +
                "* Connect it to **Sprague–Grundy numbers** (lightly, no theory dump)\n" +
                "\n" +
                "Tell me how you want to approach it next.\n");
    }
}
