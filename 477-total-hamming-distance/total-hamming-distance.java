class Solution {
    public static int totalHammingDistance(int[] nums) {
        int thc = 0;
        for(int i = 0; i< 32; i++) {
            int one = 0;
            for(int num : nums) {
                int b = num >> i & 1;
                if(b == 1) {
                    one++;
                }
            }
            thc += one * (nums.length - one);
        }
        return thc;
    }


    public static void main(String[] args) {
        int [] n = {4,14,4};
        System.out.println(totalHammingDistance(n));
    }
}