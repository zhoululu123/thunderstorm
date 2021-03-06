package cz.cuni.lf1.lge.ThunderSTORM.calibration;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 */
public class IterativeQuadraticFittingTest {
    
    double[] zpos = {1.00, 17.00, 27.00, 39.00, 42.00, 43.00, 44.00, 45.00, 46.00, 47.00, 48.00, 49.00, 50.00, 51.00, 52.00, 53.00, 54.00, 55.00, 56.00, 57.00, 58.00, 59.00, 60.00, 61.00, 62.00, 63.00, 64.00, 65.00, 66.00, 67.00, 68.00, 69.00, 70.00, 71.00, 72.00, 73.00, 74.00, 75.00, 76.00, 77.00, 78.00, 79.00, 80.00, 81.00, 82.00, 83.00, 84.00, 85.00, 86.00, 87.00, 88.00, 89.00, 90.00, 91.00, 92.00, 93.00, 94.00, 95.00, 96.00, 97.00, 98.00, 99.00, 100.00, 101.00, 102.00, 103.00, 104.00, 105.00, 106.00, 107.00, 108.00, 109.00, 110.00, 111.00, 112.00, 113.00, 114.00, 115.00, 116.00, 117.00, 118.00, 119.00, 120.00, 121.00, 122.00, 123.00, 124.00, 125.00, 126.00, 127.00, 128.00, 129.00, 130.00, 131.00, 132.00, 133.00, 134.00, 135.00, 136.00, 137.00, 138.00, 139.00, 140.00, 141.00, 142.00, 143.00, 144.00, 145.00, 146.00, 147.00, 148.00, 149.00, 150.00, 151.00, 152.00, 153.00, 154.00, 155.00, 156.00, 157.00, 158.00, 159.00, 160.00, 161.00, 162.00, 163.00, 164.00, 165.00, 166.00, 167.00, 168.00};
    double[] sigma1 = {3.47, 5.17, 4.53, 4.25, 4.06, 4.07, 3.94, 3.95, 3.83, 3.81, 3.65, 3.70, 3.63, 3.57, 3.44, 3.43, 3.47, 3.38, 3.29, 3.24, 3.07, 3.26, 3.02, 2.94, 2.91, 2.93, 2.76, 2.79, 2.74, 2.65, 2.57, 2.63, 2.52, 2.50, 2.44, 2.44, 2.34, 2.33, 2.41, 2.29, 2.34, 2.20, 2.19, 2.17, 2.17, 2.12, 2.07, 2.11, 2.16, 2.08, 2.07, 2.03, 2.03, 2.06, 2.00, 2.03, 2.03, 2.04, 2.05, 2.01, 2.03, 2.03, 1.97, 2.00, 2.00, 2.08, 2.06, 2.10, 2.07, 2.01, 2.10, 2.11, 2.06, 2.09, 2.08, 2.12, 2.15, 2.14, 2.15, 2.14, 2.19, 2.21, 2.14, 2.24, 2.29, 2.22, 2.30, 2.35, 2.34, 2.38, 2.44, 2.44, 2.51, 2.46, 2.52, 2.57, 2.62, 2.69, 2.70, 2.71, 2.71, 2.94, 2.84, 2.94, 2.97, 3.00, 3.17, 3.14, 3.21, 3.29, 3.32, 3.24, 3.49, 3.43, 3.56, 3.69, 3.72, 3.84, 3.72, 3.90, 4.07, 4.12, 4.19, 4.33, 4.45, 4.51, 4.36, 4.44, 4.69, 4.69, 4.93};
    double[] sigma2 = {4.52, 6.42, 6.00, 5.18, 5.15, 4.98, 4.85, 4.99, 4.75, 4.78, 4.78, 4.64, 4.60, 4.46, 4.32, 4.22, 4.15, 4.16, 4.03, 4.08, 3.89, 3.90, 3.74, 3.70, 3.53, 3.59, 3.59, 3.44, 3.31, 3.30, 3.21, 3.19, 3.05, 3.06, 3.03, 2.95, 2.91, 2.80, 2.87, 2.79, 2.79, 2.68, 2.66, 2.58, 2.66, 2.46, 2.49, 2.54, 2.50, 2.44, 2.42, 2.37, 2.30, 2.31, 2.33, 2.28, 2.27, 2.24, 2.25, 2.25, 2.17, 2.22, 2.17, 2.23, 2.17, 2.20, 2.17, 2.14, 2.13, 2.09, 2.15, 2.16, 2.09, 2.06, 2.10, 2.09, 2.07, 2.08, 2.04, 2.11, 2.03, 2.11, 2.10, 2.13, 2.14, 2.07, 2.18, 2.12, 2.19, 2.16, 2.26, 2.20, 2.22, 2.21, 2.29, 2.27, 2.27, 2.39, 2.27, 2.38, 2.37, 2.54, 2.52, 2.58, 2.55, 2.66, 2.68, 2.61, 2.72, 2.80, 2.82, 2.86, 2.99, 2.94, 3.10, 3.19, 3.24, 3.28, 3.34, 3.49, 3.53, 3.58, 3.54, 3.79, 3.84, 3.99, 3.89, 3.99, 4.26, 4.24, 4.36};
    
    @Test
    public void testFitParams() {
        IterativeFitting polynomialFitter = new IterativeFitting(5, 0.9);
        
        DefocusFunction sigma1params = polynomialFitter.fitParams(new DefocusFunctionPoly(), zpos, sigma1, 1000);
        System.out.println("s1: " + sigma1params);
        DefocusFunction sigma2params = polynomialFitter.fitParams(new DefocusFunctionPoly(), zpos, sigma2, 1000);
        System.out.println("s2: " + sigma2params);
        
        
        double[] expectedS1 = {1.0, 101.25497353331642, 6.231821223769346E-4, 1.9747240670414778, 2.8222606605242904E-7};
        double[] expectedS2 = {1.0, 112.65002463626868, 6.655212029439303E-4, 2.0378570872539346, 8.875601959818572E-7};
        assertArrayEquals(expectedS1, sigma1params.toParArray(), 0.001);
        assertArrayEquals(expectedS2, sigma2params.toParArray(), 0.001);
    }
    
    @Test
    public void testSmallestN() {
        double[] d = {2, 1, 1, 564, 798, 782, 34, 5, 68, 94, 61, 3};
        int[] top5 = {7, 11, 0, 2, 1};
        
        int[] calculatedTop5 = IterativeFitting.findIndicesOfSmallestN(d, 5);
        assertArrayEquals(top5, calculatedTop5);
    }
    
}