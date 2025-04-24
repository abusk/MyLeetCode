class Solution {
    public int getLargestOutlier(int[] nums) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            sum += num;
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<nums.length; i++) {
            int cSum = nums[i];
            if(map.get(cSum) == 1) {
                map.remove(cSum);
            } else {
                map.put(cSum, map.get(cSum)-1);
            }
            int restSum = sum - cSum;
            int outLier = restSum - cSum;
            if(map.containsKey(outLier)) {
                max = Math.max(max, outLier);
            }
            map.put(cSum, map.getOrDefault(cSum, 0)+1);
        }
        return max;
    }
}