// class Solution {
//     public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
//         var adjList = formAdjList(connections);
//         List<List<Integer>> ans = new ArrayList<>();
//         for(var entry : adjList.entrySet()) {
//             var u = entry.getKey();
//             var vs = entry.getValue();
//             for(int i = 0; i<vs.size(); i++) {
//                 if(isCriticalConn(adjList, n, u, vs.get(i))) {
//                     List<Integer> sans = new ArrayList<>();
//                     sans.add(u);
//                     sans.add(vs.get(i));
//                     ans.add(sans);
//                 }
//             }
//         }
//         List<List<Integer>> fans = new ArrayList<>();
//         Set<String> filter = new HashSet<>();
//         for(var edge : ans) {
//             String fo = edge.get(0) + "" + edge.get(1);
//             String of = edge.get(1) + "" + edge.get(0);
//             if(!filter.contains(fo) && !filter.contains(of)) {
//                 fans.add(edge);
//                 filter.add(fo);
//                 filter.add(of);
//             }
//         }
//         return fans;
//     }
//     public boolean isCriticalConn(Map<Integer, List<Integer>> adjList, int n, int u, int v) {
//         System.out.println(u + "--" + v);
//         int start = u;
//         Set<Integer> visited = new HashSet<>();
//         visited.add(v);
//         Queue<Integer> queue = new LinkedList<>();
//         queue.add(u);
//         while(!queue.isEmpty()) {
//             var qlen = queue.size();
//             for(int i = 0; i< qlen; i++) {
//                 var uu = queue.poll();
//                 if(!visited.contains(uu)) {
//                     visited.add(uu);
//                     var lst = adjList.get(uu);
//                     for(int vv : lst) {
//                         if(vv == start) {
//                             return false;
//                         }
//                         queue.add(vv);
//                     }
//                 }
//             }
//         }
//         return true;
//     }
//     public Map<Integer, List<Integer>> formAdjList(List<List<Integer>> connections) {
//         Map<Integer, List<Integer>> adjList = new HashMap<>();
//         for(int i = 0; i<connections.size(); i++) {
//             List<Integer> e = connections.get(i);
//             List<Integer> lst1 = adjList.getOrDefault(e.get(0), new ArrayList<>());
//             lst1.add(e.get(1));
//             adjList.put(e.get(0), lst1);

//             List<Integer> lst2 = adjList.getOrDefault(e.get(1), new ArrayList<>());
//             lst2.add(e.get(0));
//             adjList.put(e.get(1), lst2);
//         }
//         return adjList;
//     }
// }
class Solution {
    
    private Map<Integer, List<Integer>> graph;
    private Map<Integer, Integer> rank;
    private Map<Pair<Integer, Integer>, Boolean> connDict;
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
       
        this.formGraph(n, connections);
        this.dfs(0, 0);
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (Pair<Integer, Integer> criticalConnection : this.connDict.keySet()) {
            result.add(new ArrayList<Integer>(Arrays.asList(criticalConnection.getKey(), criticalConnection.getValue())));
        }
        
        return result;
    }
    
    private int dfs(int node, int discoveryRank) {
        
        // That means this node is already visited. We simply return the rank.
        if (this.rank.get(node) != null) {
            return this.rank.get(node);
        }
        
        // Update the rank of this node.
        this.rank.put(node, discoveryRank);
        
        // This is the max we have seen till now. So we start with this instead of INT_MAX or something.
        int minRank = discoveryRank + 1;
        
        for (Integer neighbor : this.graph.get(node)) {
            
            // Skip the parent.
            Integer neighRank = this.rank.get(neighbor);
            if (neighRank != null && neighRank == discoveryRank - 1) {
                continue;
            }
            
            // Recurse on the neighbor.
            int recursiveRank = this.dfs(neighbor, discoveryRank + 1);
            
            // Step 1, check if this edge needs to be discarded.
            if (recursiveRank <= discoveryRank) {
                int sortedU = Math.min(node, neighbor), sortedV = Math.max(node, neighbor);
                this.connDict.remove(new Pair<Integer, Integer>(sortedU, sortedV));
            }
            
            // Step 2, update the minRank if needed.
            minRank = Math.min(minRank, recursiveRank);
        }
        
        return minRank;
    }
    
    private void formGraph(int n, List<List<Integer>> connections) {
        
        this.graph = new HashMap<Integer, List<Integer>>();
        this.rank = new HashMap<Integer, Integer>();
        this.connDict = new HashMap<Pair<Integer, Integer>, Boolean>();
        
        // Default rank for unvisited nodes is "null"
        for (int i = 0; i < n; i++) {
            this.graph.put(i, new ArrayList<Integer>());
            this.rank.put(i, null);
        }
        
        for (List<Integer> edge : connections) {
            
            // Bidirectional edges
            int u = edge.get(0), v = edge.get(1);
            this.graph.get(u).add(v);
            this.graph.get(v).add(u);
            
            int sortedU = Math.min(u, v), sortedV = Math.max(u, v);
            connDict.put(new Pair<Integer, Integer>(sortedU, sortedV), true);
        }
    }
}