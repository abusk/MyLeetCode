class Solution {
    public int minMeetingRooms(int[][] intervals) {
        List<int[]> lst = new ArrayList<>();
        for(int[] a : intervals) {
            lst.add(a);
        }
        lst.sort((a, b) -> {
            if(a[0] == b[0]) {
                return b[1] - a[1];
            } else {
                return a[0] - b[0];
            }
            });

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        int ans = 0;
        for(int[] a : lst) {
            while (!pq.isEmpty() && pq.peek()[1] <= a[0]) {
                pq.poll();
            }
            pq.offer(a);
            ans = Math.max(ans, pq.size());
        }
        return ans;
    }
}