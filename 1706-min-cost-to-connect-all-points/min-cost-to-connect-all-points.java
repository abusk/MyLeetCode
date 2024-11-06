class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((p , q) -> (p[0] - q[0]));
        boolean isMST[] = new boolean[n];
        int minCost = 0;
        int edgesUsed = 0;

        pq.offer(new int[]{0, 0});

        while(edgesUsed < n) {
            int[] top = pq.poll();
            int cur = top[1];
            int weight = top[0];

            if(isMST[cur]) {
                continue;
            }
            minCost += weight;
            isMST[cur] = true;
            edgesUsed++;

            for(int j = 0; j<n; j++) {
                if(!isMST[j]) {
                    int c = Math.abs(points[cur][0] - points[j][0]) + Math.abs(points[cur][1] - points[j][1]);
                    pq.offer(new int[]{c, j});
                }
            }
        }
        return minCost;
    }
}

// class Solution {
//     public int minCostConnectPoints(int[][] points) {
//         int n = points.length;
        
//         // Min-heap to store minimum weight edge at top.
//         PriorityQueue<Pair<Integer, Integer>> heap = new PriorityQueue<>((a, b) -> (a.getKey() - b.getKey()));;
        
//         // Track nodes which are included in MST.
//         boolean[] inMST = new boolean[n];
        
//         heap.add(new Pair(0, 0));
//         int mstCost = 0;
//         int edgesUsed = 0;
        
//         while (edgesUsed < n) {
//             Pair<Integer, Integer> topElement = heap.poll();
            
//             int weight = topElement.getKey();
//             int currNode = topElement.getValue();
            
//             // If node was already included in MST we will discard this edge.
//             if (inMST[currNode]) {
//                 continue;
//             }
            
//             inMST[currNode] = true;
//             mstCost += weight;
//             edgesUsed++;
            
//             for (int nextNode = 0; nextNode < n; ++nextNode) {
//                 // If next node is not in MST, then edge from curr node
//                 // to next node can be pushed in the priority queue.
//                 if (!inMST[nextNode]) {
//                     int nextWeight = Math.abs(points[currNode][0] - points[nextNode][0]) + 
//                                      Math.abs(points[currNode][1] - points[nextNode][1]);
        
//                     heap.add(new Pair(nextWeight, nextNode));
//                 }
//             }
//         }
        
//         return mstCost;
//     }
// }