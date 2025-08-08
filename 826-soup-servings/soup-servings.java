// class Solution {
//     public double soupServings(int n) {
//         int m = (int)Math.ceil(n / 25.0);
//         Map<Integer, Map<Integer, Double>> dp = new HashMap<>();
//         dp.put(0, new HashMap<>());
//         dp.get(0).put(0, 0.5);

//         for (int k = 1; k <= m; k++) {
//             dp.put(k, new HashMap<>());
//             dp.get(0).put(k, 1.0);
//             dp.get(k).put(0, 0.0);
//             for (int j = 1; j <= k; j++) {
//                 dp.get(j).put(k, calculateDP(j, k, dp));
//                 dp.get(k).put(j, calculateDP(k, j, dp));
//             }
//             if (dp.get(k).get(k) > 1 - 1e-5) {
//                 return 1;
//             }
//         }

//         return dp.get(m).get(m);
//     }

//     private double calculateDP(int i, int j, Map<Integer, Map<Integer, Double>> dp) {
//         return (dp.get(Math.max(0, i - 4)).get(j)
//                 + dp.get(Math.max(0, i - 3)).get(j - 1)
//                 + dp.get(Math.max(0, i - 2)).get(Math.max(0, j - 2))
//                 + dp.get(i - 1).get(Math.max(0, j - 3))) / 4;
//     }
// }

class Solution {
    private Double[][] dp;

    public double soupServings(int n) {
        // Optimization: for large n, probability approaches 1
        if (n > 5000) return 1.0;

        int m = (int)Math.ceil(n / 25.0);
        dp = new Double[m+1][m+1];
        return findProb(m, m);
    }

    private double findProb(int a, int b) {
        if (a <= 0 && b <= 0) return 0.5;
        if (a <= 0) return 1.0;
        if (b <= 0) return 0.0;

        if (dp[a][b] != null) return dp[a][b];

        dp[a][b] = 0.25 * (
            findProb(a-4, b) +           // 100,0 → 4,0 after divide by 25
            findProb(a-3, b-1) +         // 75,25
            findProb(a-2, b-2) +         // 50,50
            findProb(a-1, b-3)           // 25,75
        );

        return dp[a][b];
    }
}
