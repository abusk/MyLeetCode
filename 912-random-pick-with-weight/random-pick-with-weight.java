class Solution {
    int [] ww;
    int sum;
    public Solution(int[] w) {
        sum = Arrays.stream(w).sum();
        ww = new int[w.length];
        ww[0] = w[0];
        for(int k = 1; k< w.length; k++) {
            ww[k] = ww[k-1] + w[k];
        }
    }

    public int bs(int target) {
        int s = 0;
        int e = ww.length;
        while(s <= e) {
            int mid = (s+e)/2;
            if(ww[mid] > target) {
                e = mid -1;
            }else {
                s = mid +1;
            }
        }
        return s;
    }
    
    public int pickIndex() {
        Random rand = new Random();
        int next = rand.nextInt(0, sum);
        return bs(next);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */