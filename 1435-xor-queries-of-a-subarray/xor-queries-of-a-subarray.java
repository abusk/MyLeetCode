class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int l = arr.length;
        int[] xors = new int[l];
        xors[0] = arr[0];
        for(int i = 1; i<l; i++) {
            xors[i] = xors[i-1] ^ arr[i];
        }
        int[] res = new int[queries.length];
        int j = 0;
        for(int[]q : queries) {
            int left = q[0];
            int right = q[1];
            if(left == 0) {
                res[j] = xors[right];
            } else {
                res[j] = xors[right] ^ xors[left -1];
            }
            j++;
        }
        return res;
    }
}