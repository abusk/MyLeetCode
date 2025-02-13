class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i = 0; i<nums.length; i++) {
            pq.offer((long)nums[i]);
        }
        int ans = 0;
        while(!pq.isEmpty() && pq.peek() < k) {
            long fst = pq.poll();
            long snd = pq.poll();
            long ps = Math.max(fst, snd) + Math.min(fst, snd) * 2;
            pq.offer(ps);
            ans++;
        }
        return ans;
    }
}