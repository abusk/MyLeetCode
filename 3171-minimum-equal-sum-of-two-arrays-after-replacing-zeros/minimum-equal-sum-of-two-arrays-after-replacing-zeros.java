class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long z1 = 0;
        long s1 = 0;
        for(int num : nums1) {
            if(num == 0) {
                z1++;
            } else {
                s1 +=num;
            }
        }
        long z2 = 0;
        long s2 = 0;
        for(int num : nums2) {
            if(num == 0) {
                z2++;
            } else {
                s2 +=num;
            }
        }
        long a1 = s1 + z1;
        long a2 = s2 + z2;
        if(a1 == a2) { 
            return a1;
        }
        if(a1 > a2 && z2 > 0) {
            return a1;
        }
        if(a2 > a1 && z1 > 0) {
            return a2;
        }
        return -1;
    }
}