class Solution {
    public void wallsAndGates(int[][] rooms) {
        int r = rooms.length;
        int c = rooms[0].length;
        boolean[][] visited;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for(int i = 0; i<r; i++) {
            for(int j = 0; j<c; j++) {
                if(rooms[i][j] == 0) {
                    visited = new boolean[r][c];
                    dfs(rooms, dirs, new int[]{i, j}, visited);
                }
            }
        }
    }
    public void dfs(int[][] rooms, int[][] dirs, int[] cur, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{cur[0], cur[1], 0});
        int cx = cur[0];
        int cy = cur[1];
        visited[cx][cy] = true;
        while(!q.isEmpty()) {
            int[] poll = q.poll();
            cx = poll[0];
            cy = poll[1];
            for(int[] dir : dirs) {
                int x = cx + dir[0];
                int y = cy + dir[1];
                if(x < 0 || x >= rooms.length || y < 0 || y >= rooms[0].length || visited[x][y] || rooms[x][y] == -1 || rooms[x][y] == 0) {
                    continue;
                }
                rooms[x][y] = Math.min(rooms[x][y], poll[2]+1);
                visited[x][y] = true;
                q.offer(new int[]{x, y, poll[2]+1});
            }
        }
    }
}