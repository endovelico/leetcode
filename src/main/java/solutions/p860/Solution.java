package solutions.p860;

class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;

        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five == 0) return false; // can't give change
                five--;
                ten++;
            } else { // bill == 20
                if (ten > 0 && five > 0) { // prefer to give $10 + $5
                    ten--;
                    five--;
                } else if (five >= 3) { // else give three $5 bills
                    five -= 3;
                } else {
                    return false; // can't give change
                }
            }
        }

        return true;
    }
}
