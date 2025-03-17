class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] -b[0]);
        List<int[]> lst = new ArrayList<>();
        lst.add(intervals[0]);
        int len = intervals.length;
        for(int i = 1; i<len; i++) {
            int[] prev = lst.getLast();
            int[] next = intervals[i];
            if(prev[1] < next[0]) {
                lst.add(next);
            } else {
                int[] newPrev = {prev[0], Math.max(prev[1], next[1])};
                lst.removeLast();
                lst.add(newPrev);
            }
        }
        int[][] ans = new int[lst.size()][2];
        int i = 0;
        for(int[] a : lst) {
            ans[i++] = a;
        }
        return ans;
    }
}