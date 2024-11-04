// class Solution {
//     public List<Integer> findMinHeightTrees(int n, int[][] edges) {
//         if(n == 1) {
//             return Arrays.asList(0);
//         }
//         Map<Integer, List<Integer>> graph = new HashMap<>();
//         for(var edge : edges) {
//             List<Integer> tos = graph.getOrDefault(edge[0], new ArrayList<>());
//             tos.add(edge[1]);
//             graph.put(edge[0], tos);
//             List<Integer> froms = graph.getOrDefault(edge[1], new ArrayList<>());
//             froms.add(edge[0]);
//             graph.put(edge[1], froms);
//         }
//         List<int[]> maxs = new ArrayList<>();
//         for(int node = 0; node<n; node++) {
//             boolean[] visited = new boolean[n];
//             Queue<Integer> queue = new LinkedList<>();
//             queue.offer(node);
//             visited[node] = true;
//             int maxH = 0;
//             while(!queue.isEmpty()) {
//                 int size = queue.size();
//                 for(int i = 0; i<size; i++) {
//                     int cur = queue.poll();
//                     for(int next: graph.get(cur)) {
//                         if(!visited[next]) {
//                             queue.offer(next);
//                             visited[next] = true;
//                         }
//                     }
//                 }
//                 maxH++;
//             }
//             maxs.add(new int[] {node, maxH});
//         }
//         maxs.sort((a, b)-> a[1]-b[1]);
//         List<Integer> ans = new ArrayList<>();
//         if(!maxs.isEmpty()) {
//             int[] fst = maxs.get(0);
//             ans.add(fst[0]);
//             for(int i = 1; i<maxs.size(); i++) {
//                 int[] next = maxs.get(i);
//                 if(next[1] == fst[1]) {
//                     ans.add(next[0]);
//                 } else {
//                     break;
//                 }
//             }
//         }
//         return ans;
//     }
// }
class Solution {
    private Map<Integer, List<Integer>> generateGraph(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(var edge : edges) {
            List<Integer> tos = graph.getOrDefault(edge[0], new ArrayList<>());
            tos.add(edge[1]);
            graph.put(edge[0], tos);
            List<Integer> froms = graph.getOrDefault(edge[1], new ArrayList<>());
            froms.add(edge[0]);
            graph.put(edge[1], froms);
        }
        return graph;
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = generateGraph(edges);
        int[] degree = new int[n];
        for(var edge: edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        Set<Integer> nodeSet = new HashSet<>();
        for(int i =0; i<n; i++) {
            nodeSet.add(i);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i =0; i<n; i++) {
            if(degree[i] == 1) {
                q.offer(i);
            }
        }
        while(nodeSet.size() > 2) {
            int qSize = q.size();
            for(int i = 0; i<qSize; i++) {
                int cur = q.poll();
                nodeSet.remove(cur);
                for(int next : graph.get(cur)) {
                    degree[next]--;
                    if(degree[next] == 1) {
                        q.offer(next);
                    }
                }
            }
        }
        return new ArrayList<>(nodeSet);
    }
}