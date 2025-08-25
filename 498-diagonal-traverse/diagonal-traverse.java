class Solution {
    public static int[] findDiagonalOrder(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;
        boolean up = true;
        int  i = 0;
        int j = 0;
        int[] ans = new int[r * c];
        int k = 0;
        while(i < r && j < c) {
            ans[k++] = mat[i][j];
            if(up) {
                if(i == 0 && j < c-1) {
                    j++;
                    up = false;
                } else if(j == c-1 && i >= 0) {
                    i++;
                    up = false;
                } else {
                    i--;
                    j++;
                }
            } else {
                if(i == r-1 && j >= 0) {
                    j++;
                    up = true;
                } else if(j == 0 && i < r-1) {
                    i++;
                    up = true;
                } else {
                    i++;
                    j--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] mat = {{1,2,3,7},{4,5,6,0},{7,8,9,5}};
        int[] res = findDiagonalOrder(mat);
        for (int a: res) {
            System.out.print(a +" ");
        }
    }
}