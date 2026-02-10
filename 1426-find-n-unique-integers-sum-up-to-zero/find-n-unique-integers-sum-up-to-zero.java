class Solution {
    public int[] sumZero(int n) {
       int mid = n / 2;
       int[] ans = new int[n];
       if(n % 2 == 0) {
        int c = 0;
        for(int i = 1; i <= mid; i++) {
            ans[c++] = i;
            ans[c++] = i * -1;
        }
       } else {
        int c = 0;
        ans[c++] = 0;
        for(int i = 1; i <= mid; i++) {
            ans[c++] = i;
            ans[c++] = i * -1;
        }
       }
       return ans;
    }
}