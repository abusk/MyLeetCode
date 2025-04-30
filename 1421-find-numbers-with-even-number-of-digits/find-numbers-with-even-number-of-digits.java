class Solution {
    public int findNumbers(int[] nums) {
        int c = 0;
        for(int num : nums){
            String ns = String.valueOf(num);
            if(ns.length() %2 == 0) {
                c++;
            }
        }
        return c;
    }
}