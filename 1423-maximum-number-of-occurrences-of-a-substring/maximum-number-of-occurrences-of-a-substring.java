class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String, Integer> map = new HashMap<>();
        Map<Character, Integer> chMap = new HashMap<>();
        int i = 0;
        int ans = 0;
        for(int j = 0; j < s.length(); j++) {
            //Expand
            char ch = s.charAt(j);
            chMap.put(ch, chMap.getOrDefault(ch, 0)+1);

            
            int subLen = j - i +1;
            if(subLen == minSize) {
                //Fixed window, make operations
                if(chMap.size() <= maxLetters) {
                    String subS = s.substring(i, j+1);
                    map.put(subS, map.getOrDefault(subS, 0)+1);
                    ans = Math.max(ans, map.get(subS));
                }
                // Shrink
                char cr = s.charAt(i);
                int c = chMap.get(cr)-1;
                if(c == 0) {
                    chMap.remove(cr);
                } else {
                    chMap.put(cr, c);
                }
                i++;
            }
        }
        return ans;
    }
}