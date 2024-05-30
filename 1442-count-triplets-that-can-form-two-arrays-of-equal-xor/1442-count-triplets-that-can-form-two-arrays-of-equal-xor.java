class Solution {
    public int countTriplets(int[] arr) {
        int c = 0;
        int l = arr.length;
        for(int k = 0; k<l; k++) {    
            int a = 0;
            for(int i = k; i<l; i++) {
                a ^= arr[i];
                int b = 0;
                for(int j = i+1; j<l; j++) {
                    b^=arr[j];
                    if(a == b) {
                        c++;
                    }
                }
            }
        }
        return c;
    }
}