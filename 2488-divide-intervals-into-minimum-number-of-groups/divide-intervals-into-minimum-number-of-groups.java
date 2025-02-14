class Solution {
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int [] fst = intervals[0];
        pq.offer(fst[1]);
        int c = 1;
        for(int i = 1; i < intervals.length; i++) {
            int [] snd = intervals[i];
            if(snd[0] <= fst[1] && pq.peek() >= snd[0]) {
                c++;
                pq.offer(snd[1]);
            } else {
                pq.poll();
                pq.offer(snd[1]);
            }
            fst = snd;
        }
        return c;
    }
}