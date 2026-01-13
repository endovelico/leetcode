package solutions.p1137;

class Solution {


    public int tribonacci(int n) {

        int[] memo = new int[n + 1];
        return tribonacci_auxiliar(n, memo);
    }

    public int tribonacci_auxiliar(int n, int[] memo) {
        if( n <= 1) return n;
        if( n == 2) return 1;
        if(memo[n] != 0) return memo[n];

        return memo[n] = tribonacci_auxiliar(n - 1, memo) + tribonacci_auxiliar(n - 2, memo) + tribonacci_auxiliar(n - 3, memo);
    }


}
