class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int[][] grid = new int[26][26];
        for(int i = 0; i<26; i++) {
            for(int j = 0; j<26; j++) {
                if(i == j) {
                    grid[i][j] = 0;
                } else {
                    grid[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for(int i = 0; i<original.length; i++) {
            grid[original[i] - 'a'][changed[i] - 'a'] = Math.min(grid[original[i] - 'a'][changed[i] - 'a'], cost[i]);
        }
        int[][] dist = minPath(grid);
        long minv = 0;
        for(int i = 0; i<source.length(); i++) {
            char src = source.charAt(i);
            char dest = target.charAt(i);
            if(src == dest) {
                continue;
            }
            int d = dist[src - 'a'][dest - 'a'];
            if(d == Integer.MAX_VALUE) {
                minv = -1;
                break;
            }
            minv += dist[src - 'a'][dest - 'a'];
        }
        return minv;
    }
    public int[][] minPath(int[][] grid) {
        int [][] dist = new int[grid.length][grid[0].length];
        for(int i = 0; i<grid.length; i++) {
            for(int j = 0; j<grid[0].length; j++) {
                dist[i][j] = grid[i][j];
            }
        }
        for(int c = 0; c<26; c++) {
            for(int i = 0; i<26; i++) {
                for(int j = 0; j<26; j++) {
                    if(dist[i][c] != Integer.MAX_VALUE && dist[c][j] != Integer.MAX_VALUE) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][c] + dist[c][j]);
                    }
                }
            }
        }
        return dist;
    }
}