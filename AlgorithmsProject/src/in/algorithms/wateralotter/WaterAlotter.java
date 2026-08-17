package in.algorithms.wateralotter;

import java.util.HashMap;
import java.util.Map;

public class WaterAlotter {
    public Map<Integer, Double> allotWater(double totalWater, int rows, double glassCapacity) {
        Map<Integer, Double> glasses = new HashMap<>();
        int totalGlasses = rows * (rows + 1) / 2;
        double[] glassArr = new double[totalGlasses + 2];
        glassArr[1] = totalWater;

        int index = 1;
        for (int r = 1; r <= rows; r++) {
            for (int c = 1; c <= r; c++) {
                double amount = glassArr[index];
                if (amount > glassCapacity) {
                    double overflow = (amount - glassCapacity) / 2.0;
                    glassArr[index] = glassCapacity;
                    int leftChild = index + r;
                    int rightChild = index + r + 1;
                    if (leftChild < glassArr.length) glassArr[leftChild] += overflow;
                    if (rightChild < glassArr.length) glassArr[rightChild] += overflow;
                }
                glasses.put(index, glassArr[index]);
                index++;
            }
        }
        return glasses;
    }
}
