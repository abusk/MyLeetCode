class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int i = 0;
        int j = 0;
        while(j < s.length()) {
            char jch = s.charAt(j);
            while(i < j && map.containsKey(jch)) {
                map.remove(s.charAt(i));
                i++;
            }
            map.put(jch, 1);
            max = Math.max(max, j - i + 1);
            j++;
        }
        return max;
    }
}