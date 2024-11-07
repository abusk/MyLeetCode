class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if(len < k) {
            return new int[0];
        }
        Deque<Integer> mq = new ArrayDeque<>();
        int res[] = new int[len-k+1];
        for(int i = 0; i<len; i++) {
            if(!mq.isEmpty() && mq.peekFirst() < i-k+1) {
                mq.pollFirst();
            }
            while(!mq.isEmpty() && nums[mq.peekLast()] <= nums[i]) {
                mq.pollLast();
            }
            mq.offer(i);
            if(i >= k-1) {
                res[i-k+1] = nums[mq.peekFirst()];
            }
        }
        return res;
    }
}