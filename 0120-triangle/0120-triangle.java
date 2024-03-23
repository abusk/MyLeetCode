// class Solution {
//     private Map<String, Integer> cache;
//     private int dp(List<List<Integer>> triangle, int i, int j){
//         String key = i+"" +j;
//         if(cache.containsKey(key)){
//             return cache.get(key);
//         }
//         int cv = triangle.get(i).get(j);
//         if(i < triangle.size() -1) {
//             cv += Math.min(dp(triangle, i+1, j), dp(triangle, i+1, j+1));
//         }
//         cache.put(key, cv);
//         return cv;
//     }
//     public int minimumTotal(List<List<Integer>> triangle) {
//         cache = new HashMap<>();
//         return dp(triangle, 0, 0);
//     }
// }

class Solution {
    
    private Map<String, Integer> memoTable;
    private List<List<Integer>> triangle;
    
    private int minPath(int row, int col) {
        String params = row + ":" + col;
        if (memoTable.containsKey(params)) {
            return memoTable.get(params);
        } 
        int path = triangle.get(row).get(col);
        if (row < triangle.size() - 1) {
            path += Math.min(minPath(row + 1, col), minPath(row + 1, col + 1));
        }
        memoTable.put(params, path);
        return path;
    }
    
    public int minimumTotal(List<List<Integer>> triangle) {
        this.triangle = triangle;
        memoTable = new HashMap<>();
        return minPath(0, 0);
    }
}
