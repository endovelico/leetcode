package solutions.p470;

class Solution {

    public int rand10() {
        while (true) {
            // Generate a uniform number from 1 to 49
            int num = (rand7() - 1) * 7 + rand7();

            // Accept only 1–40
            if (num <= 40) {
                // Map to 1–10 uniformly
                return (num - 1) % 10 + 1;
            }
            // 41–49 → reject and retry
        }
    }

    public int rand7() {
        return (int)(Math.random() * 7) + 1;
    }
}
