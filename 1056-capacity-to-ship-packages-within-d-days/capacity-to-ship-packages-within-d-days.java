class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int total = 0;
        int max = 0;
        for(int weight : weights) {
            total += weight;
            max = Math.max(max, weight);
        }
        int l = max; int r = total;
        while (l < r) {
            int mid = (l+r) / 2;
            if(isValid(weights, days, mid)) {
                r = mid;
            } else {
                l = mid +1;
            }
        }
        return l;
    }
    public boolean isValid(int[] weights, int days, int c) {
        int daysNeeded = 1;
        int curLoad = 0;
        for(int weight : weights) {
            curLoad += weight;
            if(curLoad > c) {
                daysNeeded++;
                curLoad = weight;
            }
        }
        return daysNeeded <= days;
    }
}