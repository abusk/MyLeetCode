class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tGain = 0, cGain = 0;
        int pos = 0;
        for(int i = 0; i<gas.length; i++) {
            tGain += gas[i] - cost[i];
            cGain += gas[i] - cost[i];
            if(cGain < 0) {
                cGain = 0;
                pos = i+1;
            }
        }
        return tGain >= 0 ? pos : -1;
    }
}