class Solution {
    public int minimumCost(int n, int[][] connections) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
 
        for(int i = 0; i<connections.length; i++) {
            int[] p = connections[i];
            int p0 = p[0]-1;
            int p1 = p[1]-1;
            int p2 = p[2];

            List<int[]> v1 = graph.getOrDefault(p0, new ArrayList<>());
            v1.add(new int[] {p2, p1});
            graph.put(p0, v1);

            List<int[]> v2 = graph.getOrDefault(p1, new ArrayList<>());
            v2.add(new int[] {p2, p0});
            graph.put(p1, v2);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((p, q) -> (p[0] - q[0]));
        pq.offer(new int[]{0,0});
        int minCost = 0;
        Set<Integer> mst = new HashSet<>();
        while(!pq.isEmpty()) {
            int[] poll = pq.poll();
            int cur = poll[1];
            int w = poll[0];
            if(mst.contains(cur)) {
                continue;
            }
            mst.add(cur);
            minCost += w;
            
            for(int[] nextNode : graph.get(cur)) {
                if(!mst.contains(nextNode[1])) {
                    pq.offer(nextNode);
                }
            }
        }
        if(mst.size() < n) {
            return -1;
        } else {
            return minCost;
        }
        
    }
}