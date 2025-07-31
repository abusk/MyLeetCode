class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int max = 0;
        while (j < s.length()) {
            char cj = s.charAt(j);
            map.put(cj, map.getOrDefault(cj, 0)+1);
            while(map.size() > 2) {
                char ci = s.charAt(i);
                int cii = map.get(ci)-1;
                if(cii == 0) {
                    map.remove(ci);
                } else {
                    map.put(ci, cii);
                }
                i++; 
            }
            max = Math.max(max, j-i +1);
            j++;
        }
        return max;
    }
}