class Solution {
    public static boolean isScramble(String s1, String s2) {
        Map<String, Boolean> memo = new HashMap<>();
        return dp(s1, s2, memo);
    }
    public static boolean dp(String s1, String s2, Map<String, Boolean> memo) {
        if(s1.equals(s2)) {
            return true;
        }
        String key = s1 + "_" + s2;
        if(memo.containsKey(key)) {
            return memo.get(key);
        }
        int n = s1.length();
        boolean result = false;
        for(int i = 1; i<n; i++) {
            boolean notSwapped = dp(s1.substring(0, i), s2.substring(0, i), memo) && dp(s1.substring(i), s2.substring(i), memo);
            boolean swapped = dp(s1.substring(0, i), s2.substring(n - i), memo) && dp(s1.substring(i), s2.substring(0, n - i), memo);
            result = result || notSwapped || swapped;
        }
        memo.put(key, result);
        return result;
    }
    public static void main(String[] args) {
        System.out.println(isScramble("abcde", "caebd"));
    }
}