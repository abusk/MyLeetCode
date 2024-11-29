class Solution {
    int m;
    int n;
    int[][] dir = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, -1}, {-1, 1}, {1, -1}};
    public char[][] updateBoard(char[][] board, int[] click) {
        m = board.length;
        n = board[0].length;
        dfs(board, click[0], click[1]);
        return board;
    }
    public void dfs(char[][] board, int x, int y) {
        if(x < 0 || x >= m || y < 0 || y >= n) {
            return;
        }
        if(board[x][y] == 'M') {
            board[x][y] = 'X';
            return;
        }
        if(board[x][y] == 'E') {
            int adjM =  mineAdjacent(board, x, y);
            if(adjM == 0) {
                board[x][y] = 'B';
                for(int[] d : dir) {
                    dfs(board, x + d[0], y + d[1]);
                }
            } else {
                board[x][y] = (char) (adjM + '0');
            }
        }
        return;
    }
    public int mineAdjacent(char[][] board, int x, int y) {
        int c = 0;
        for(int[] d : dir) {
            int nx = x + d[0];
            int ny = y + d[1];
            if(nx >= 0 && nx < m && ny >=0 && ny < n && board[nx][ny] == 'M') {
                c++;
            }
        }
        return c;
    }
}