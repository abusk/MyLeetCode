class Solution {
    public static int minimumDeleteSum(String s1, String s2) {
        Map<String, Integer> memo = new HashMap<>();
        return dp(s1, s2, 0, 0, memo);
    }
    public static int dp(String s1, String s2, int i, int j, Map<String, Integer> memo) {
        if(i >= s1.length()) {
            int dc = 0;
            for (int k = j; k <s2.length(); k++) {
                dc += s2.charAt(k);
            }
            return dc;
        }
        if(j >= s2.length()) {
            int dc = 0;
            for (int k = i; k <s1.length(); k++) {
                dc += s1.charAt(k);
            }
            return dc;
        }

        String key = i + ":" +j;
        if(memo.containsKey(key)) {
            return memo.get(key);
        }
        if(s1.charAt(i) == s2.charAt(j)) {
            return dp(s1, s2, i+1, j+1, memo);
        }
        int fst = s1.charAt(i) + dp(s1, s2, i+1, j, memo);
        int snd = s2.charAt(j) + dp(s1, s2, i, j+1, memo);
        int thr = s1.charAt(i) + s2.charAt(j) + dp(s1, s2, i+1, j+1, memo);
        int res = Math.min(fst, Math.min(snd, thr));
        memo.put(key, res);
        return res;
    }
}