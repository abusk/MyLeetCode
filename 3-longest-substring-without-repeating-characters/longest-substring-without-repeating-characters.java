class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Boolean> map = new HashMap<>();
        int i =0;
        int j = 0;
        int ans = 0;
        while(i < s.length()) {
            char ith = s.charAt(i);
            Boolean exist = map.get(ith);
            if(exist == null || !exist) {
                ans = Math.max(ans, i - j + 1);
            } else {
                char jth = s.charAt(j);
                do {
                    jth = s.charAt(j);
                    map.put(jth, false);
                    j++;
                } while (ith != jth);
            }
            i++;
            map.put(ith, true);
        }
        return ans;
    }
}