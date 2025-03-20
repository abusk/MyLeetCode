class Solution {
    public int findMinMoves(int[] machines) {
        int totalDresses = 0;
        int n = machines.length;

        // Calculate total dresses
        for (int dresses : machines) {
            totalDresses += dresses;
        }

        // If not evenly divisible, return -1
        if (totalDresses % n != 0) {
            return -1;
        }

        int target = totalDresses / n; // Target dresses per machine
        int loadBalance = 0, maxMoves = 0;

        // Traverse machines and calculate min moves
        for (int i = 0; i < n; i++) {
            int diff = machines[i] - target;
            loadBalance += diff; // Accumulate imbalance
            maxMoves = Math.max(maxMoves, Math.max(Math.abs(loadBalance), diff));
        }

        return maxMoves;
    }
}
