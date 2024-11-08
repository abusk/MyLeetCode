class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        Deque<Integer> minQ = new ArrayDeque<>();
        Deque<Integer> maxQ = new ArrayDeque<>();
        long ans = 0;
        int left = -1;
        for(int i = 0; i<nums.length; i++) {
            int num = nums[i];
            if(num < minK || num > maxK) {
                left = i;
                minQ.clear();
                maxQ.clear();
                continue;
            }

            if(num == minK) {
                minQ.addFirst(i);
            }
            if(num == maxK) {
                maxQ.addFirst(i);
            }
            while(!minQ.isEmpty() && minQ.peekFirst() <= left) {
                minQ.pollFirst();
            }
            while(!maxQ.isEmpty() && maxQ.peekFirst() <= left) {
                maxQ.pollFirst();
            }
            if(!minQ.isEmpty() && !maxQ.isEmpty()) {
                int right = Math.min(minQ.peekFirst(), maxQ.peekFirst());
                //ans += valRight-left;
                ans += Math.max(0, right - left);
            }
        }
        return ans;
    }
}