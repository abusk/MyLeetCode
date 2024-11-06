
// class Solution {
//     public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
//         PriorityQueue<int[]> pq = new PriorityQueue<>((p, q) -> (p[0] - q[0]));
        
//         int[][] graph = new int[n+1][n+1];
//         for(int i = 0; i<wells.length; i++) {
//             graph[0][i] = wells[i];
//             graph[i][0] = wells[i];
//             pq.offer(new int[]{wells[i], i+1});
//         }
//         for(int i = 1; i<=n; i++) {
//             for(int j = 1; j<=n; j++) {
//                 graph[i][j] = -1;
//             }
//         }
//         for(int i = 0; i<pipes.length; i++) {
//             int r = pipes[i][0];
//             int c = pipes[i][1];
//             int w = pipes[i][2];
//             graph[r][c] = w;
//             graph[c][r] = w;
//         }

//         int minCost = 0;
//         Set<Integer> mstSet = new HashSet<>();
//         mstSet.add(0);
//         while(mstSet.size() < n+1) {
//             int[] top = pq.poll();
//             int cur = top[1];
//             int w = top[0];
//             if (mstSet.contains(cur)) {
//                 continue;
//             }
//             mstSet.add(cur);
//             minCost += w;
//             for(int next = 0; next<=n; next++) {
//                 if(!mstSet.contains(next) && graph[cur][next] != -1) {
//                     int newW = graph[cur][next];
//                     pq.offer(new int[]{newW, next});
//                 }
//             }
//         }
//         return minCost;
//     }
// }

class Solution {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        // min heap to maintain the order of edges to be visited.
        PriorityQueue<Pair<Integer, Integer>> edgesHeap =
                new PriorityQueue<>(n, (a, b) -> (a.getKey() - b.getKey()));

        // representation of graph in adjacency list
        List<List<Pair<Integer, Integer>>> graph = new ArrayList<>(n + 1);
        for (int i = 0; i < n + 1; ++i) {
            graph.add(new ArrayList<Pair<Integer, Integer>>());
        }

        // add a virtual vertex indexed with 0,
        //   then add an edge to each of the house weighted by the cost
        for (int i = 0; i < wells.length; ++i) {
            Pair<Integer, Integer> virtualEdge = new Pair<>(wells[i], i + 1);
            graph.get(0).add(virtualEdge);
            // initialize the heap with the edges from the virtual vertex.
            edgesHeap.add(virtualEdge);
        }

        // add the bidirectional edges to the graph
        for (int i = 0; i < pipes.length; ++i) {
            int house1 = pipes[i][0];
            int house2 = pipes[i][1];
            int cost = pipes[i][2];
            graph.get(house1).add(new Pair<Integer, Integer>(cost, house2));
            graph.get(house2).add(new Pair<Integer, Integer>(cost, house1));
        }

        // kick off the exploration from the virtual vertex 0
        Set<Integer> mstSet = new HashSet<>();
        mstSet.add(0);

        int totalCost = 0;
        while (mstSet.size() < n + 1) {
            Pair<Integer, Integer> edge = edgesHeap.poll();
            int cost = edge.getKey();
            int nextHouse = edge.getValue();
            if (mstSet.contains(nextHouse)) {
                continue;
            }

            // adding the new vertex into the set
            mstSet.add(nextHouse);
            totalCost += cost;

            // expanding the candidates of edge to choose from in the next round
            for (Pair<Integer, Integer> neighborEdge : graph.get(nextHouse)) {
                if (!mstSet.contains(neighborEdge.getValue())) {
                    edgesHeap.add(neighborEdge);
                }
            }
        }

        return totalCost;
    }
}