import java.util.*;

public class FractionalKnapsack {
    public static double getMaxValue(int[] values, int[] weights, int capacity) {
        int n = values.length;
        double totalValue = 0.0;

        // Create an array of value/weight ratios and sort based on that ratio
        Double[] ratios = new Double[n];
        for (int i = 0; i < n; i++) {
            ratios[i] = (double) values[i] / weights[i];
        }

        // Sort ratios in descending order
        Arrays.sort(ratios, Collections.reverseOrder());

        // Add items to the knapsack based on sorted ratios
        for (int i = 0; i < n; i++) {
            if (capacity >= weights[i]) {
                capacity -= weights[i];
                totalValue += values[i];
            } else {
                totalValue += values[i] * ((double) capacity / weights[i]);
                break;
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        int[] values = { 60, 100, 120 };
        int[] weights = { 10, 20, 30 };
        int capacity = 50;

        System.out.println("Maximum value in Knapsack = " + getMaxValue(values, weights, capacity));
    }
}
