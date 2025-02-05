class Solution {
    public int[] lastMarkedNodes(int[][] edges) {
        // Step 1: Build Adjacency List
        int n = edges.length +1;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // Step 2: Find the farthest node from any arbitrary node (0)
        int farthestA = bfsFarthestNode(n, graph, 0);

        // Step 3: Find the farthest node from farthestA
        int farthestB = bfsFarthestNode(n, graph, farthestA);

        // Step 4: Compute distances from both endpoints (farthestA and farthestB)
        int[] distA = bfsDistances(n, graph, farthestA);
        int[] distB = bfsDistances(n, graph, farthestB);
        
        // Step 5: For each node, find the farthest reachable node
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = (distA[i] > distB[i]) ? farthestA : farthestB;
        }
        
        return result;
    }

    // BFS to find the farthest node from a given start node
    private int bfsFarthestNode(int n, List<List<Integer>> graph, int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.add(start);
        visited[start] = true;
        int farthestNode = start;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            farthestNode = node;
            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        return farthestNode;
    }

    // BFS to compute distances from a given start node
    private int[] bfsDistances(int n, List<List<Integer>> graph, int start) {
        Queue<Integer> queue = new LinkedList<>();
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        queue.add(start);
        dist[start] = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph.get(node)) {
                if (dist[neighbor] == -1) { // Not visited
                    dist[neighbor] = dist[node] + 1;
                    queue.add(neighbor);
                }
            }
        }
        return dist;
    }
}