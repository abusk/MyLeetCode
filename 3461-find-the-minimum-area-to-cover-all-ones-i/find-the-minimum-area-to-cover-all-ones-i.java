class Solution {
    public static int minimumArea(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        List<int[]> lst = new ArrayList<>();
        for(int i = 0; i<m; i++) {
            for(int left = 0; left<n; left++) {
                if(grid[i][left] != 0) {
                    lst.add(new int[]{i, left});
                    break;
                }
            }
            for(int right = n-1; right>=0; right--) {
                if (grid[i][right] != 0) {
                    lst.add(new int[]{i, right});
                    break;
                }
            }
        }
        if(lst.isEmpty()) {
            return 0;
        }

        int vertical = lst.get(lst.size() - 1)[0] - lst.get(0)[0] + 1;
        int right = 0;
        int left = n;
        for(int i = 0; i<lst.size(); i+=2) {
            left = Math.min(left, lst.get(i)[1]);
            right = Math.max(right, lst.get(i+1)[1]);
        }
        int horizontal = right - left + 1;
        return vertical * horizontal;
    }

    public static void main(String[] args) {
        int[][] grid = {{0,0,0},{0,0,0},{0,0,1}, {0,1,0}};
        System.out.println(minimumArea(grid));
    }
}