class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int sl = spells.length;
        int pl = potions.length;
        int[] res = new int[sl];
        int i = 0;
        Arrays.sort(potions);
        for(int s : spells){
            long t = (long) Math.ceil((1.0 * success) / s);
            if(potions[0] >= t){
                res[i++] = pl;
            }else if(potions[pl-1] < t){
                res[i++] = 0;
            } else {
                int index = lowerBound(potions, (int) t);
                res[i++] = pl - index;
            }
        }
        return res;
    }
    
    private int lowerBound(int[] arr, int key) {
        int lo = 0;
        int hi = arr.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] < key) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}