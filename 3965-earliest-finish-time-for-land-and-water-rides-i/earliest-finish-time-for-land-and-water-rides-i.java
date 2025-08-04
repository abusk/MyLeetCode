class Solution {
    public static int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<landStartTime.length; i++) {
            int ls = landStartTime[i];
            int ld = landDuration[i];
            int le = ls + ld;
            for(int j = 0; j<waterStartTime.length; j++) {
                int ws = waterStartTime[j];
                int wd = waterDuration[j];
                int we = ws + wd;

                int finish1 = Math.max(le, ws) + wd;

                int finish2 = Math.max(we, ls) + ld;

                min = Math.min(min, Math.min(finish1, finish2));
            }
        }
        return min;
    }
}