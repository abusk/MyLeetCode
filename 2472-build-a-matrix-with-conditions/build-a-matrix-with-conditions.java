class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[] rows = arrange(k, rowConditions);
        int[] cols = arrange(k, colConditions);
        int[][] ans = new int[k][k];
        if(rows.length == 0 || cols.length == 0) {
            return new int[0][0];
        }
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                if (rows[i] == cols[j]) {
                    ans[i][j] = rows[i];
                }
            }
        }
        return ans;
    }
    private int[] arrange(int k, int[][] conditions) {
        int[] inbound = new int[k+1];
        inbound[0] = Integer.MIN_VALUE;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i= 0; i<conditions.length; i++) {
            inbound[conditions[i][1]]++;
            List<Integer> lst = map.getOrDefault(conditions[i][0], new ArrayList<>());
            lst.add(conditions[i][1]);
            map.put(conditions[i][0], lst);
        }
        int [] res = new int[k];
        int j = 0;
        while(true) {
            int i = getZeroNode(inbound);
            if(i == -1) {
                if(isLoop(inbound, k)) {
                    return new int[0];
                } else {
                    return res;
                }
            }
            res[j++] = i;
            removeLink(inbound, map, i);
        }
    }
    private void removeLink(int[] inbound, Map<Integer, List<Integer>> map, int i) {
        inbound[i] = Integer.MIN_VALUE;
        List<Integer> lst = map.get(i);
        if(lst != null) {
            for(int a: lst) {
                inbound[a]--;
            }
        }
    }
    private int getZeroNode(int[] inbound) {
        for(int i = 0; i<inbound.length; i++) {
            if(inbound[i] == 0) {
                return i;
            }
        }
        return -1;
    }
    private boolean isLoop(int[] inbound, int k) {
        boolean inRange = false;
        boolean noZero = true;
        for(int i= 0; i<inbound.length; i++) {
            if(inbound[i] >= 1 && inbound[i] <= k) {
                inRange = true;
            }
        }
        for(int i= 0; i<inbound.length; i++) {
            if(inbound[i] == 0) {
                noZero = false;
            }
        }
        return inRange && noZero;
    }
}

// class Solution {

//     public int[][] buildMatrix(
//         int k,
//         int[][] rowConditions,
//         int[][] colConditions
//     ) {
//         int[] orderRows = topoSort(rowConditions, k);
//         int[] orderColumns = topoSort(colConditions, k);
//         if (
//             orderRows.length == 0 || orderColumns.length == 0
//         ) return new int[0][0];
//         int[][] matrix = new int[k][k];
//         for (int i = 0; i < k; i++) {
//             for (int j = 0; j < k; j++) {
//                 if (orderRows[i] == orderColumns[j]) {
//                     matrix[i][j] = orderRows[i];
//                 }
//             }
//         }
//         return matrix;
//     }

//     private int[] topoSort(int[][] edges, int n) {
//         List<Integer>[] adj = new ArrayList[n + 1];
//         for (int i = 0; i <= n; i++) {
//             adj[i] = new ArrayList<Integer>();
//         }
//         int[] deg = new int[n + 1], order = new int[n];
//         int idx = 0;
//         for (int[] x : edges) {
//             adj[x[0]].add(x[1]);
//             deg[x[1]]++;
//         }
//         Queue<Integer> q = new LinkedList<>();
//         for (int i = 1; i <= n; i++) {
//             if (deg[i] == 0) q.offer(i);
//         }
//         while (!q.isEmpty()) {
//             int f = q.poll();
//             order[idx++] = f;
//             n--;
//             for (int v : adj[f]) {
//                 if (--deg[v] == 0) q.offer(v);
//             }
//         }
//         if (n != 0) return new int[0];
//         return order;
//     }
// }