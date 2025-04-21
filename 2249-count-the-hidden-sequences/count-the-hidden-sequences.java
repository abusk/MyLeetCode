class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int len = differences.length;
        int[] dif = new int[len+1];
        dif[0] = 0;
        for(int i = 0; i<len; i++) {
            dif[i+1] = dif[i] + differences[i];
        } 
        Arrays.sort(dif);
        int lr = lower - dif[0];
        int ur = upper - dif[len];
        if((lr >= lower && lr <= upper) && (ur >= lower && ur <= upper) && ur >= lr) {
            return ur - lr +1;
        } 
        return 0;
    }
}