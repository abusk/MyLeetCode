class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int ans = 0;
        while(j < s.length()) {
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0)+1);
            while(map.get(ch) > 1) {
                char shr = s.charAt(i);
                map.put(shr, Math.max(0, map.get(shr)-1));
                i++;
            }
            j++;
            ans = Math.max(ans, j-i);
        }
        return ans;
    }
}