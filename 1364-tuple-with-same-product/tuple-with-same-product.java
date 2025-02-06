class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            for(int j = i+1; j<nums.length; j++) {
                int prd = nums[i] * nums[j];
                map.put(prd, map.getOrDefault(prd, 0)+1);
            }
        }
        int totalCount = map.values().stream().mapToInt(a -> ((a-1) * a) / 2).sum();
        return totalCount * 8;
    }
}