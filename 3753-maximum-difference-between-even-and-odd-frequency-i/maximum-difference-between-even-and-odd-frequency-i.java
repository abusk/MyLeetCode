class Solution {
    public int maxDifference(String s) {
        int[] count = new int [26];
        for(int i = 0; i<s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        int maxOdd = Integer.MIN_VALUE;
        int minEven = Integer.MAX_VALUE;
        for(int i = 0; i<26; i++) {
            if(count[i] == 0) {
                continue;
            }
            if(count[i] % 2 != 0) {
                maxOdd = Math.max(maxOdd, count[i]);
            } else {
                minEven = Math.min(minEven, count[i]);
            }
        }
        return maxOdd - minEven;
    }
}