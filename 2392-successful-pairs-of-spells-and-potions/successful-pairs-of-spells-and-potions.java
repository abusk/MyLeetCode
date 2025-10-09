class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int pl = potions.length;
        int sl = spells.length;
        int ans[] = new int[sl];
        for(int i = 0; i< sl; i++) {
            if((long)potions[0] * spells[i] >= success) {
                ans[i] = pl;
            } else if((long)potions[pl-1] * spells[i] < success) {
                ans[i] = 0;
            } else {
                int ps = bs(potions, spells[i], success);
                ans[i] = pl - ps;
            }
        }
        return ans;
    }

    public int bs(int[] potions, int spell, long success) {
        int len = potions.length;
        int result = len;
        int start = 0;
        int end = len-1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if((long)potions[mid] * spell >= success) {
                result = mid;
                end = mid -1;
            } else {
                start = mid+1;
            }
        }
        return result;
    }
}