package solutions.p2469;

public class Solution {

    public double[] convertTemperature(double celsius) {
        return new double[] {
                celsius + 273.15,        // Kelvin
                celsius * 1.80 + 32.00   // Fahrenheit
        };
    }
}
