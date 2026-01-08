class Solution {
    public boolean exist(char[][] board, String word) {
        int r = board.length;
        int c = board[0].length;
        for(int i = 0; i<r; i++) {
            for(int j = 0; j<c; j++) {
                boolean[][] visited = new boolean[r][c];
                boolean res = dfs(board, i, j, word, 0, visited);
                if(res) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int r, int c, String word, int i, boolean[][] visited) {
        if(i >= word.length()) {
            return true;
        }
        if(r < 0 || r >= board.length || c < 0 || c >= board[0].length || visited[r][c]) {
            return false;
        }
        char ch = word.charAt(i);
        if(board[r][c] == ch) {
            visited[r][c] = true;
            boolean res  = dfs(board, r-1, c, word, i+1, visited) || dfs(board, r, c+1, word, i+1, visited) || dfs(board, r+1, c, word, i+1, visited) || dfs(board, r, c-1, word, i+1, visited);
            visited[r][c] = false;
            return res;
        }
        return false;
    }
}