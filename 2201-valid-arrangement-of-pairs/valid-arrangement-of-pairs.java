// class Solution {
//     public int[][] validArrangement(int[][] pairs) {
//         Map<Integer, LinkedList<Integer>> map = new HashMap<>();
//         for(int[] p : pairs) {
//             var lst = map.getOrDefault(p[0], new LinkedList<>());
//             lst.offer(p[1]);
//             map.put(p[0], lst);
//         }
//         List<int[]> res = new ArrayList<>();
//         for(int a : map.keySet()) {
//             res = dfs(new HashMap<>(map), a, new ArrayList<>());
//             if(res.size() == pairs.length){
//                 break;
//             }
//         }
//         int[][] ans = new int[pairs.length][pairs[0].length];
//         int i = 0;
//         for(int[] r : res) {
//             ans[i++] = r;
//         }
//         return ans;
//     }
//     public List<int[]> dfs(Map<Integer, LinkedList<Integer>> map, int src, List<int[]> res) {
//         var nxt = map.get(src);
//         if(nxt == null || nxt.isEmpty()) {
//             return res;
//         }
//         while(!nxt.isEmpty()) {
//             int v = nxt.pollFirst();
//             dfs(map, v, res);
//             res.add(new int[] {src, v});
//         }
//         return res;
//     }
// }

class Solution {
    public int[][] validArrangement(int[][] pairs) {
        int m = pairs.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer, Integer> degree = new HashMap<>();
        for(int[] pair : pairs){
            int from = pair[0];
            int to = pair[1];
            map.putIfAbsent(from, new ArrayList<>());
            map.get(from).add(to);
            degree.putIfAbsent(from, 0);
            degree.put(from, degree.get(from) - 1);
            degree.putIfAbsent(to, 0);
            degree.put(to, degree.get(to) + 1);
        }
        int start = -1;
        for(int key : degree.keySet()){
            if(degree.get(key) == -1){
                start = key;
                break;
            }
        }
        if(start == -1){
            start = pairs[0][0];
        }
        List<Integer> path = new ArrayList<>();
        dfs(path, start, map);
        int[][] result = new int[m][2];
        for(int i = 0; i < path.size() - 1; i++){
            result[i][0] = path.get(i);
            result[i][1] = path.get(i + 1);
        }
        return result;
    }
    private void dfs(List<Integer> path, int start, Map<Integer, List<Integer>> map){
        List<Integer> neighbors = map.get(start);
        while(neighbors != null && !neighbors.isEmpty()){
            int next = neighbors.get(0);
            neighbors.remove(0);
            dfs(path, next, map);
        }
        path.add(0, start);
    }
}