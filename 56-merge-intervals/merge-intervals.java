class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> lst = new ArrayList<>();
        for(int[] val : intervals) {
            if(lst.isEmpty()) {
                lst.add(val);
            } else {
                int[] lstLast = lst.getLast();
                if (lstLast[1] >= val[0]) {
                    int[] newEnt = new int[] {lstLast[0], Math.max(val[1], lstLast[1])};
                    lst.removeLast();
                    lst.add(newEnt);
                } else {
                    lst.add(val);
                }
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