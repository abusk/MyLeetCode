class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int []ind = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>(numCourses);
        for(int i = 0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }
        
        for (int[] prerequisite : prerequisites) {
            adj.get(prerequisite[1]).add(prerequisite[0]);
            ind[prerequisite[0]]++;
        }
        
        int [] ans = new int[numCourses];
        Arrays.fill(ans, -1);
        int k = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<numCourses; i++){
            if(ind[i] == 0) {
                q.offer(i);
                ans[k++] = i;
            }
        }
        while(!q.isEmpty()){
            int node = q.poll();
            for(int nei : adj.get(node)){
                ind[nei]--;
                if(ind[nei] == 0) {
                    q.offer(nei);
                    ans[k++] = nei;
                }
            }
        }
        boolean notUp = Arrays.stream(ans).anyMatch(value -> value == -1);
        if(notUp) return new int[0];
        return ans;
    }
}