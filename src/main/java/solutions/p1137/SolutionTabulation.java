package solutions.p1137;

public class SolutionTabulation {

    public int tribonacci(int n) {

        int[] tabulated = new int[n + 1];
        if(n == 0) return 0;
        if(n <= 2) return 1;

        tabulated[0] = 0;
        tabulated[1] = 1;
        tabulated[2] = 1;

        for(int i = 3; i <= n; i++) {

            tabulated[i] = tabulated[i -1] + tabulated[i - 2] + tabulated[i-3];
        }
        return tabulated[n];
    }
}
