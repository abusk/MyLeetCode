class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        double max = 0.0;
        int area = 0;
        for(int[] dim : dimensions) {
            int l = dim[0];
            int w = dim[1];
            double ll = l * l;
            double ww = w * w;
            double lmax = Math.sqrt(ll + ww);
            System.out.println(lmax);
            if(lmax > max) {
                area = l * w;
                max = lmax;
            } else if(lmax == max) {
                int larea = l * w;
                if(larea > area) {
                    area = larea;
                }
            }
        }
        return area;
    }
}