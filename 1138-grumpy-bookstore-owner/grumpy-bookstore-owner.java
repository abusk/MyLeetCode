class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int l = customers.length;
        int total = 0;
        for(int k = 0; k<l; k++) {
            if(grumpy[k] == 0) {
                total += customers[k];
            }
        }

        int wl = 0;
        int i = 0; 
        int j = 0;
        int max = 0;
        int extra = 0;
        while (j < l && i <= j) {
            if(wl < minutes) {
                if(grumpy[j] == 1) {
                    extra += customers[j];
                    max = Math.max(max, extra);
                }
                j++;
                wl++;
            } else {
                if(grumpy[i] == 1) {
                    extra -= customers[i];
                }
                i++;
                wl--;
            }
        }
        return total + max;
    }
}