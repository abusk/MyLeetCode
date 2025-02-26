// class Solution {

//     public int maxAbsoluteSum(int[] nums) {
//         int minPrefixSum = Integer.MAX_VALUE, maxPrefixSum = Integer.MIN_VALUE;
//         int prefixSum = 0, maxAbsSum = 0;

//         for (int i = 0; i < nums.length; i++) {
//             // Prefix sum from index 0 to i
//             prefixSum += nums[i];

//             // Minimum & Maximum prefix sum we have seen so far
//             minPrefixSum = Math.min(minPrefixSum, prefixSum);
//             maxPrefixSum = Math.max(maxPrefixSum, prefixSum);

//             if (prefixSum >= 0) {
//                 // If the prefixSum is positive, we will get the difference between prefixSum &
//                 // minPrefixSum
//                 maxAbsSum = Math.max(
//                     maxAbsSum,
//                     Math.max(prefixSum, prefixSum - minPrefixSum)
//                 );
//             } else if (prefixSum <= 0) {
//                 // If the prefixSum is negative, we will get the absolute difference between
//                 // prefixSum & maxPrefixSum
//                 maxAbsSum = Math.max(
//                     maxAbsSum,
//                     Math.max(
//                         Math.abs(prefixSum),
//                         Math.abs(prefixSum - maxPrefixSum)
//                     )
//                 );
//             }
//         }

//         return maxAbsSum;
//     }
// }

class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int max_sum = 0, min_sum = 0, max_absolute_sum = 0;
        
        for (int num : nums) {
            max_sum = Math.max(num, max_sum + num);  // Maximum sum subarray
            min_sum = Math.min(num, min_sum + num);  // Minimum sum subarray
            max_absolute_sum = Math.max(max_absolute_sum, Math.abs(max_sum));
            max_absolute_sum = Math.max(max_absolute_sum, Math.abs(min_sum));
        }
        
        return max_absolute_sum;
    }
}
