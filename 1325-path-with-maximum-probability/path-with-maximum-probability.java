// class Solution {
//     public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
//         double[][] graph = new double[n][n];
//         boolean visited[] = new boolean[n];
//         for(int i = 0; i<edges.length; i++) {
//             int r = edges[i][0];
//             int c = edges[i][1];
//             double w = succProb[i];
//             graph[r][c] = w;
//             graph[c][r] = w;
//         }
//         PriorityQueue<Pair<Integer, Double>> pq = new PriorityQueue<>((a, b) -> (b.getValue().compareTo(a.getValue())));
//         double dist[] = new double[n];
//         Arrays.fill(dist, 0.0);
//         dist[start_node] = 1.0;
//         pq.offer(new Pair(start_node, 1.0));

//         while(!pq.isEmpty()) {
//             var poll = pq.poll();
//             int curNode = poll.getKey();
//             double curvalue = poll.getValue();
//             if(curNode == end_node) {
//                 return curvalue;
//             }
//             visited[curNode] = true;
//             for(int j = 0; j<n; j++) {
//                 double newVal = graph[curNode][j] * curvalue;
//                 if(!visited[j] && curNode != j && newVal > dist[j]) {
//                     dist[j] = newVal;
//                     pq.add(new Pair(j, newVal));
//                 }
//             }
//         }
//         return 0d;
//     }
// }

class Solution {

    public double maxProbability(
        int n,
        int[][] edges,
        double[] succProb,
        int start,
        int end
    ) {
        Map<Integer, List<Pair<Integer, Double>>> graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1];
            double pathProb = succProb[i];
            graph
                .computeIfAbsent(u, k -> new ArrayList<>())
                .add(new Pair<>(v, pathProb));
            graph
                .computeIfAbsent(v, k -> new ArrayList<>())
                .add(new Pair<>(u, pathProb));
        }

        double[] maxProb = new double[n];
        maxProb[start] = 1d;

        PriorityQueue<Pair<Double, Integer>> pq = new PriorityQueue<>((a, b) ->
            -Double.compare(a.getKey(), b.getKey())
        );
        pq.add(new Pair<>(1.0, start));
        while (!pq.isEmpty()) {
            Pair<Double, Integer> cur = pq.poll();
            double curProb = cur.getKey();
            int curNode = cur.getValue();
            if (curNode == end) {
                return curProb;
            }
            if (graph.containsKey(curNode)) { // Check if the node has been processed
                for (Pair<Integer, Double> nxt : graph.getOrDefault(
                    curNode,
                    new ArrayList<>()
                )) {
                    int nxtNode = nxt.getKey();
                    double pathProb = nxt.getValue();
                    if (curProb * pathProb > maxProb[nxtNode]) {
                        maxProb[nxtNode] = curProb * pathProb;
                        pq.add(new Pair<>(maxProb[nxtNode], nxtNode));
                    }
                }
                graph.remove(curNode); // Clear the adjacency list by removing the entry
            }
        }

        return 0d;
    }
}