// class Solution {
//     public Pair<Integer, Integer> getNext(char[][] board, int i, int j, int[][] vis){
//         if(i >= 0 && j>= 0 && i < board.length && j <board[0].length && board[i][j] == 'O' && vis[i][j] != 1){
//             return new Pair(i, j);
//         } 
//         return null;
//     }
//     public void solve(char[][] board) {
//         int m = board.length;
//         int n = board[0].length;
//         int [][] vis = new int[m][n];
//         for(int i = 0; i<m; i++) {
//             for(int j = 0; j<n; j++){
//                 vis[i][j] = 0;
//             }
//         }
//         Queue<Pair<Integer, Integer>> q = new LinkedList<>();
//         List<Pair<Integer, Integer>> lis = new ArrayList<>();
//         for(int i = 0; i<m; i++) {
//             for(int j = 0; j<n; j++){
//                 if(board[i][j] == 'O' && vis[i][j] != 1) {
//                     q.offer(new Pair(i, j));
//                     vis[i][j] = 1;
//                     lis.add(new Pair(i, j));
//                 }
//                 while(!q.isEmpty()) {
//                     Pair<Integer, Integer> p = q.poll();
//                     if(p.getKey()==m-1 || p.getKey()==0|| p.getValue() == n-1 || p.getValue() == 0) {
//                         q.clear();
//                         lis.clear();
//                         break;
//                     } else {
//                         int ro = p.getKey();
//                         int cl = p.getValue();
//                         List<Pair<Integer, Integer>> nei = new ArrayList<>();
//                         nei.add(getNext(board, ro-1, cl, vis));
//                         nei.add(getNext(board, ro+1, cl, vis));
//                         nei.add(getNext(board, ro, cl-1, vis));
//                         nei.add(getNext(board, ro, cl+1, vis));
//                         for(Pair<Integer, Integer> nextPair : nei) {
//                             if(nextPair != null) {
//                                 q.offer(nextPair);
//                                 lis.add(nextPair);
//                                 vis[nextPair.getKey()][nextPair.getValue()] = 1;
//                             }
//                         }
//                     }
//                 }
//                 for(Pair<Integer, Integer> pr : lis) {
//                     board[pr.getKey()][pr.getValue()] = 'X';
//                 }
//                 lis.clear();
//             }
//         }
//     }
// }

public class Solution {
  protected Integer ROWS = 0;
  protected Integer COLS = 0;

  public void solve(char[][] board) {
    if (board == null || board.length == 0) {
      return;
    }
    this.ROWS = board.length;
    this.COLS = board[0].length;

    List<Pair<Integer, Integer>> borders = new LinkedList<Pair<Integer, Integer>>();
    // Step 1). construct the list of border cells
    for (int r = 0; r < this.ROWS; ++r) {
      borders.add(new Pair(r, 0));
      borders.add(new Pair(r, this.COLS - 1));
    }
    for (int c = 0; c < this.COLS; ++c) {
      borders.add(new Pair(0, c));
      borders.add(new Pair(this.ROWS - 1, c));
    }

    // Step 2). mark the escaped cells
    for (Pair<Integer, Integer> pair : borders) {
      this.DFS(board, pair.first, pair.second);
    }

    // Step 3). flip the cells to their correct final states
    for (int r = 0; r < this.ROWS; ++r) {
      for (int c = 0; c < this.COLS; ++c) {
        if (board[r][c] == 'O')
          board[r][c] = 'X';
        if (board[r][c] == 'E')
          board[r][c] = 'O';
      }
    }
  }

  protected void DFS(char[][] board, int row, int col) {
    if (board[row][col] != 'O')
      return;

    board[row][col] = 'E';
    if (col < this.COLS - 1)
      this.DFS(board, row, col + 1);
    if (row < this.ROWS - 1)
      this.DFS(board, row + 1, col);
    if (col > 0)
      this.DFS(board, row, col - 1);
    if (row > 0)
      this.DFS(board, row - 1, col);
  }
}


class Pair<U, V> {
  public U first;
  public V second;

  public Pair(U first, V second) {
    this.first = first;
    this.second = second;
  }
}
