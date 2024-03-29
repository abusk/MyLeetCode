// class Solution {
//     public long countSubarrays(int[] nums, int k) {
//         int mx = Arrays.stream(nums).max().orElse(0);
//         int c = 0;
//         int i = 0; 
//         int j = 0;
//         int ans = 0;
//         while(j < nums.length) {
//             if(nums[j] == mx) {
//                 c++;
//             }
//             while(c >=k){
//                 if(nums[i] == mx){
//                     c--;
//                 }
//                 i++;
//             }
//             ans +=i;
//             j++;
//         }
//         return ans;
//     }
// }

class Solution {
    public long countSubarrays(int[] nums, int k) {
        int maxElement = Arrays.stream(nums).max().getAsInt();
        long ans = 0;
        int start = 0, maxElementsInWindow = 0;

        for (int end = 0; end < nums.length; end++) {
            if (nums[end] == maxElement) {
                maxElementsInWindow++;
            }
            while (k == maxElementsInWindow) {
                if (nums[start] == maxElement) {
                    maxElementsInWindow--;
                }
                start++;
            }
            ans += start;
        }

        return ans;
    }
}