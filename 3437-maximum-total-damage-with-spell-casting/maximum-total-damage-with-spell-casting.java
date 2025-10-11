class Solution {
    public long maximumTotalDamage(int[] power) {
        // Count frequency of each power value
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int p : power) {
            freqMap.put(p, freqMap.getOrDefault(p, 0) + 1);
        }
        
        // Convert to list and sort by power value
        List<int[]> powerList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            powerList.add(new int[]{entry.getKey(), entry.getValue()});
        }
        powerList.sort((a, b) -> Integer.compare(a[0], b[0]));
        
        int n = powerList.size();
        long[] memo = new long[n];
        Arrays.fill(memo, -1);
        
        return dp(powerList, 0, memo);
    }
    
    private long dp(List<int[]> powerList, int index, long[] memo) {
        if (index >= powerList.size()) {
            return 0;
        }
        
        if (memo[index] != -1) {
            return memo[index];
        }
        
        int currentPower = powerList.get(index)[0];
        long currentValue = (long) currentPower * powerList.get(index)[1];
        
        // Option 1: Skip current power
        long skip = dp(powerList, index + 1, memo);
        
        // Option 2: Take current power
        // Find the next index we can take (first power that's not conflicting)
        int nextIndex = index + 1;
        while (nextIndex < powerList.size() && 
               (powerList.get(nextIndex)[0] == currentPower + 1 || 
                powerList.get(nextIndex)[0] == currentPower + 2 ||
                powerList.get(nextIndex)[0] == currentPower - 1 ||
                powerList.get(nextIndex)[0] == currentPower - 2)) {
            nextIndex++;
        }
        
        long take = currentValue + dp(powerList, nextIndex, memo);
        
        long result = Math.max(skip, take);
        memo[index] = result;
        return result;
    }
}