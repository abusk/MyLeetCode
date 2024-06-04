class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i< s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        int evenSum = 0;
        int maxOdd = 0;
        for(int num: map.values()) {
            if(num % 2 == 0) {
                evenSum += num;
            } else {
                maxOdd = 1;
                evenSum += num-1;
            }
        }
        return evenSum + maxOdd;
    }
}