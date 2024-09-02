class Solution {
    public int[] sortArray(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> a-b);
        for(int num : nums) {
            pq.offer(num);
        }
        int[] sorted = new int[nums.length];
        int i= 0;
        while(!pq.isEmpty()) {
            sorted[i++] = pq.poll();
        }
        return sorted;
    }
}