package solutions.p509;

public class BinetsSolution {

    public static int fib(int n) {

        double sqrt5 = Math.sqrt(5);
        double phi = (1 + sqrt5) / 2;

        double fibN = Math.pow(phi, n) / sqrt5;

        // Rounding is necessary because result may be slightly off due to floating-point precision
        return (int) Math.round(fibN);
    }
}