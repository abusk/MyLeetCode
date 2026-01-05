class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int minVal = Integer.MAX_VALUE;
        long sum = 0;
        int cn = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix.length; j++) {
                int val = matrix[i][j];
                int aval = Math.abs(val);
                sum += aval;
                minVal = Math.min(minVal, aval);
                if(val < 0) {
                    cn++;
                }
            }
        }
        if(cn % 2 != 0) {
            sum -= 2 * minVal;
        }
        return sum;
    }
}