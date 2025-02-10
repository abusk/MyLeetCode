class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
       PriorityQueue<int[]> minH = new PriorityQueue<>((a, b) -> a[0] - b[0]);
       PriorityQueue<int[]> maxH = new PriorityQueue<>((a, b) -> b[0]-a[0]);
       int i = 0;
       for(List<Integer> lst : arrays) {
        minH.offer(new int[] {lst.getFirst(), i});
        maxH.offer(new int[] {lst.getLast(), i});
        i++;
       }
       int ans = Integer.MIN_VALUE;
       int[] minTop = minH.peek();
       int [] maxTop = maxH.peek();
       while(!maxH.isEmpty()) {
        if(minTop[1] != maxH.peek()[1]) {
            ans = Math.max(ans, Math.abs(maxH.peek()[0] - minTop[0]));
            break;
        } else {
            maxH.poll();
        }
       }
       while(!minH.isEmpty()) {
        if(maxTop[1] != minH.peek()[1]) {
            ans = Math.max(ans, Math.abs(minH.peek()[0] - maxTop[0]));
            break;
        } else {
            minH.poll();
        }
       }
       return ans;
    }
}