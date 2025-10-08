class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int len = spells.length;
        int[] ans = new int[len];
        for(int i = 0; i<len; i++) {
            long t = (long) Math.ceil((1.0 * success) / spells[i]);
            if(t <= potions[0]) {
                ans[i] = potions.length;
            } else if(t > potions[potions.length-1]) {
                ans[i] = 0;
            } else {
                int pos = bs(potions, t);
                ans[i] = potions.length - pos;
            }
        }
        return ans;
    }
    public int bs(int[] potions, long val) {
        int start = 0;
        int end = potions.length-1;
        while(start < end) {
            int mid = (start + end) /2;
            if(potions[mid] < val) {
                start = mid +1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}