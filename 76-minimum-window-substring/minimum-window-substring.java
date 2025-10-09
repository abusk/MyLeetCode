class Solution {
    public static String minWindow(String s, String t) {
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();
        for(char ch : t.toCharArray()) {
            tMap.put(ch, tMap.getOrDefault(ch, 0) +1);
        }
        int len = s.length();
        int i = 0;
        int j = 0;
        int min = len;
        String ans = "";
        while(i < len) {
            char ch = s.charAt(i);
            sMap.put(ch, sMap.getOrDefault(ch, 0)+1);
            while (j < i && isValidRemove(sMap, tMap, s.charAt(j))) {
                j++;
            }
            if(found(sMap, tMap)) {
                int lmin = i - j;
                if(lmin < min) {
                    ans = s.substring(j, i+1);
                    min = lmin;
                }
            }
            i++;
        }
        return ans;
    }
    public static boolean isValidRemove(Map<Character, Integer> sMap, Map<Character, Integer> tMap, char ch) {
        if(!tMap.containsKey(ch)) {
            int v = sMap.get(ch) -1;
            if(v == 0) {
                sMap.remove(ch);
            } else {
                sMap.put(ch, v);
            }
            return true;
        } else {
            int needV = tMap.get(ch);
            int haveV = sMap.get(ch);
            if(needV >= haveV) {
                return false;
            } else{
                sMap.put(ch, haveV-1);
                return true;
            }
        }
    }
    public static boolean found(Map<Character, Integer> sMap, Map<Character, Integer> tMap) {
        for(var entry : tMap.entrySet()) {
            char key = entry.getKey();
            int val = entry.getValue();
            if(sMap.containsKey(key) && sMap.get(key) >= val) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(minWindow("Ab", "A"));
    }
}