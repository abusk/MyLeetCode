class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int c = 0;
        for(int i = 0; i< arr.length; i++) {
            if(arr[i] % 2 == 0) {
                c =0;
            } else {
                c++;
            }
            if(c == 3) {
                return true;
            }
        }
        return false;
    }
}