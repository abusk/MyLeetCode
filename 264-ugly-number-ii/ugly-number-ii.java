class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        Set<Long> nums = new HashSet<>();

        int[] primeFactors = { 2, 3, 5 };
        
        pq.offer(1L);
        nums.add(1L);
        long num = 1L;
        for(int i = 0; i < n; i++ ) {
            num = pq.poll();
            for(int prime : primeFactors) {
                long next = num * prime;
                if(!nums.contains(next)) {
                    pq.offer(next);
                    nums.add(next);
                }
            }
        }
        return (int)num;
    }
}