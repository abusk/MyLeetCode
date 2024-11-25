// class Solution {
//     public int leastBricks(List<List<Integer>> wall) {
//         List<Integer> firstRow = wall.get(0);
//         int totalSize = 0;
//         for(int w : firstRow) {
//             totalSize += w;
//         }
//         int len = (totalSize * 2) - 1;
//         char[][] board = new char[wall.size()][len];
//         for(int i = 0; i<wall.size(); i++) {
//             fill(board, i, wall.get(i));
//         }
//         int minC = Integer.MAX_VALUE;
//         for(int i = 0; i<len; i++) {
//             int c = getCross(board, i);
//             minC = Math.min(minC, c);
//         }
//         return minC;
//     }
//     public int getCross(char[][] board, int col) {
//         int c = 0;
//         for(int i=0; i<board.length; i++) {
//             if(board[i][col] == 'x') {
//                 c++;
//             }
//         }
//         return c;
//     }
//     public void fill(char[][] board, int row, List<Integer> vals) {
//         int col = 0;
//         for(int v : vals) {
//             int range = v * 2 -1;
//             for(int j = col; j < col + range; j++) {
//                 board[row][j] = 'x';
//             }
//             col = col + range+1;
//         }
//     }
// }

class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        for(List<Integer> r : wall) {
            int nextGap = 0;
            for(int i = 0; i < r.size() -1; i++) {
                nextGap += r.get(i);
                map.put(nextGap, map.getOrDefault(nextGap, 0)+1);
            }
        }
        int maxGap = 0;
        for(int a : map.values()) {
            maxGap = Math.max(maxGap, a);
        }
        return wall.size() - maxGap;
    }
}