class KthLargest {
    PriorityQueue<Integer> pq;
    int limit;
    public KthLargest(int k, int[] nums) {
        this.limit = k;
        this.pq = new PriorityQueue<>(k);
        int l = Math.min(k, nums.length);
        for(int i =0; i<l; i++) {
            pq.offer(nums[i]);
        }
        for(int i = l; i<nums.length; i++) {
            if(pq.peek() < nums[i]) {
                pq.poll();
                pq.offer(nums[i]);
            }
        }
    }
    
    public int add(int val) {
        if(pq.isEmpty() || pq.size() < limit) {
            pq.offer(val);
        } else if(pq.peek() < val) {
            pq.poll();
            pq.offer(val);
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */