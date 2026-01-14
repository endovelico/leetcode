package solutions.p504;

class Solution {
    public String convertToBase7(int num) {

        if(num == 0) return "0";

        StringBuilder result = new StringBuilder();
        boolean wasNegative = false;
        if(num < 0) { num = Math.abs(num); wasNegative=true;}

        while(num > 0) {
            result.append(num % 7);
            num /= 7;
        }

        if(wasNegative) result.append("-");

        return result.reverse().toString();
    }
}