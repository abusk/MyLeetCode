class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length-1;
        List<int[]> up = new ArrayList<>();
        List<int[]> lp = new ArrayList<>();
        for(int i = 0; i<n; i++) {
            lp.add(new int[]{i, 0});
            if(i == 0) {
                continue;
            }
            up.add(new int[]{0, i});
        }
        for(int[] start : up) {
            List<Integer> nums = new ArrayList<>();
            int i = start[0];
            int j = start[1];
            while(j <= n) {
                nums.add(grid[i][j]);
                i++;
                j++;
            }
            nums.sort((a, b) -> a -b);
            i = start[0];
            j = start[1];
            int k = 0;
            while(j <= n) {
                grid[i][j] = nums.get(k++);
                i++;
                j++;
            }
        }

        for(int[] start : lp) {
            List<Integer> nums = new ArrayList<>();
            int i = start[0];
            int j = start[1];
            while(i <= n) {
                nums.add(grid[i][j]);
                i++;
                j++;
            }
            nums.sort((a, b) -> b - a);
            i = start[0];
            j = start[1];
            int k = 0;
            while(i <= n) {
                grid[i][j] = nums.get(k++);
                i++;
                j++;
            }
        } 
        return grid;
    }
}