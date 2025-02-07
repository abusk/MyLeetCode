import java.util.*;

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums); // Sorting ensures divisibility relations are checked in order
        int n = nums.length;
        List<List<Integer>> dp = new ArrayList<>(n);
        
        // Initialize DP table
        for (int i = 0; i < n; i++) {
            dp.add(new ArrayList<>());
            dp.get(i).add(nums[i]);
        }

        List<Integer> maxSubset = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {  // Direct divisibility check
                    if (dp.get(j).size() + 1 > dp.get(i).size()) {
                        dp.set(i, new ArrayList<>(dp.get(j))); // Copy subset
                        dp.get(i).add(nums[i]); // Add current number
                    }
                }
            }
            // Track the largest subset
            if (dp.get(i).size() > maxSubset.size()) {
                maxSubset = dp.get(i);
            }
        }
        return maxSubset;
    }
}
