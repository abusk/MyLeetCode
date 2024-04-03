// class Solution {
//     public static List<List<Integer>> dir = Arrays.asList(Arrays.asList(0, 0), Arrays.asList(0, 1), Arrays.asList(0, -1), Arrays.asList(1, 0), Arrays.asList(-1, 0)); 
//     public boolean backtrack(int i, int j, int k, char[][] board, int[][] vis, String word, String formed) {
//         if(formed.equals(word)) {
//             return true;
//         }
//         for(List<Integer> pair : dir) {
//             int x = i + pair.get(0);
//             int y = j + pair.get(1);
//             boolean rs = true;
//             if(x >=0 && x < board.length && y >=0 && y < board[0].length && k < word.length()) {
//                 if(board[x][y] == word.charAt(k) && vis[x][y] == 0) {
//                     formed += board[x][y];
//                     vis[x][y] = 1;
//                     rs = backtrack(x, y, k++, board, vis, word, formed);
//                 }
//             }
//             if(!rs) {
//                 formed = formed.substring(0, formed.length()-1);
//                 vis[x][y] = 0;
//             } 
//         }
//         return false;
//     }
//     public boolean exist(char[][] board, String word) {
//         int m = board.length;
//         int n = board[0].length;
//         int [][] vis = new int[m][n];
//         for(int i = 0; i <m; i++) {
//             for(int j = 0; j<n; j++) {
//                 boolean f = backtrack(i, j, 0, board, vis, word, "");
//                 if(f) {
//                     return true;
//                 }
//             }
//         }
//         return false;
//     }
// }


class Solution {
  private char[][] board;
  private int ROWS;
  private int COLS;

  public boolean exist(char[][] board, String word) {
    this.board = board;
    this.ROWS = board.length;
    this.COLS = board[0].length;

    for (int row = 0; row < this.ROWS; ++row)
      for (int col = 0; col < this.COLS; ++col)
        if (this.backtrack(row, col, word, 0))
          return true;
    return false;
  }

  protected boolean backtrack(int row, int col, String word, int index) {
    /* Step 1). check the bottom case. */
    if (index >= word.length())
      return true;

    /* Step 2). Check the boundaries. */
    if (row < 0 || row == this.ROWS || col < 0 || col == this.COLS
        || this.board[row][col] != word.charAt(index))
      return false;

    /* Step 3). explore the neighbors in DFS */
    boolean ret = false;
    // mark the path before the next exploration
    this.board[row][col] = '#';

    int[] rowOffsets = {0, 1, 0, -1};
    int[] colOffsets = {1, 0, -1, 0};
    for (int d = 0; d < 4; ++d) {
      ret = this.backtrack(row + rowOffsets[d], col + colOffsets[d], word, index + 1);
      if (ret)
        break;
    }

    /* Step 4). clean up and return the result. */
    this.board[row][col] = word.charAt(index);
    return ret;
  }
}
