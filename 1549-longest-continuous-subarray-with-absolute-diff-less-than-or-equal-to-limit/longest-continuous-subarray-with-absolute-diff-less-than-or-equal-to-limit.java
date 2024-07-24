// class Solution {
//     public int longestSubarray(int[] nums, int limit) {
//         PriorityQueue<Integer> pmx = new PriorityQueue<>((a, b) -> b -a);
//         PriorityQueue<Integer> pmn = new PriorityQueue<>((a, b) -> a -b);
//         pmx.offer(nums[0]);
//         pmn.offer(nums[0]);
//         int max = 1;
//         for(int i = 1; i < nums.length; i++) {
//             while(!pmx.isEmpty() && Math.abs(pmx.peek() - nums[i]) > limit) {
//                 pmx.poll();
//             }
//             pmx.offer(nums[i]);
//             while(!pmn.isEmpty() && Math.abs(pmn.peek() - nums[i]) > limit) {
//                 pmn.poll();
//             }
//             pmn.offer(nums[i]);
//             max = Math.max(max, Math.min(pmx.size(), pmn.size()));
//         }
//         return max;
//     }
// }

class Solution {

    public int longestSubarray(int[] nums, int limit) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> b[0] - a[0]
        );
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            Comparator.comparingInt(a -> a[0])
        );

        int left = 0, maxLength = 0;

        for (int right = 0; right < nums.length; ++right) {
            maxHeap.offer(new int[] { nums[right], right });
            minHeap.offer(new int[] { nums[right], right });

            // Check if the absolute difference between the maximum and minimum values in the current window exceeds the limit
            while (maxHeap.peek()[0] - minHeap.peek()[0] > limit) {
                // Move the left pointer to the right until the condition is satisfied.
                // This ensures we remove the element causing the violation
                left = Math.min(maxHeap.peek()[1], minHeap.peek()[1]) + 1;

                // Remove elements from the heaps that are outside the current window
                while (maxHeap.peek()[1] < left) {
                    maxHeap.poll();
                }
                while (minHeap.peek()[1] < left) {
                    minHeap.poll();
                }
            }

            // Update maxLength with the length of the current valid window
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}