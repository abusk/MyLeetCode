class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int fLen = fruits.length;
        int bLen = baskets.length;
        boolean [] bTaken = new boolean[bLen];
        
        for(int i = 0; i<fLen; i++) {
            int fq = fruits[i];
            for(int j = 0; j<bLen; j++) {
                if(bTaken[j]) {
                    continue;
                }
                int bc = baskets[j];
                if(fq <= bc) {
                    bTaken[j] = true;
                    break;
                }
            }
        }
        int ans = 0;
        for(int i = 0; i<bLen; i++) {
            if(bTaken[i] == false) {
                ans++;
            }
        }
        return ans;
    }
}