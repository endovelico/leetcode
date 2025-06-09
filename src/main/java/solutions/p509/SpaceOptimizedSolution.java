package solutions.p509;

public class SpaceOptimizedSolution {

    public static long fib(int n) {
        if (n <= 1) return 1;

        long prev2 = 0;
        long prev1 = 1;

        for (int i = 2; i <= n; i++) {
            long current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }

    public static void main(String[] args) {
        int n = 50;
        long result = fib(n);
        System.out.println("Fibonacci(" + n + ") = " + result);
    }
}

