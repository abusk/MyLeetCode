class Solution {
    public double largestTriangleArea(int[][] points) {
        int len = points.length;
        double largest = 0;
        for(int i = 0; i<len; i++) {
            int[] p1 = points[i];
            for(int j = i+1; j <len; j++) {
                int[] p2 = points[j];
                for(int k = j + 1; k <len; k++) {
                    int[] p3 = points[k];
                    double lmax = calculate(p1, p2, p3);
                    largest = Math.max(largest, lmax);
                }
            }
        }
        return largest;
    }

    public double calculate(int[] p1, int[] p2, int[] p3) {
        double dd = p1[0] * p2[1] + p2[0] * p3[1] + p3[0] * p1[1];
        double add = p1[1] * p2[0] + p2[1] * p3[0] + p3[1] * p1[0];
        return 0.5 * Math.abs(dd - add);
    }
}