class Solution {
    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        Map<Character, Integer> pMap = new HashMap<>();
        for(char ch : pattern.toCharArray()) {
            pMap.put(ch, pMap.getOrDefault(ch, 0) +1);
        }
        List<String> ans = new ArrayList<>();
        for(String word : words) {
            Map<Character, Integer> wMap = new HashMap<>();
            for(char ch : word.toCharArray()) {
                wMap.put(ch, wMap.getOrDefault(ch, 0) +1);
            }
            Map<Character, Integer> pMapCopy = new HashMap<>(pMap);
            if(isMatchedMap(pMap, pMapCopy) && checkOrder(word, pattern, wMap, pMapCopy) && checkMapping(word, pattern)) {
                ans.add(word);
            }
        }
        return ans;
    }
    public static boolean checkMapping(String w, String p) {
        Map<Character, Character> map = new HashMap<>();
        for(int i = 0; i<w.length(); i++) {
            char wch = w.charAt(i);
            char pch = p.charAt(i);
            if(map.containsKey(wch)) {
                if(map.get(wch) != pch) {
                    return false;
                }
            } else {
                map.put(wch, pch);
            }
        }
        return true;
    }

        public static boolean isMatchedMap(Map<Character, Integer> pMap, Map<Character, Integer> wMap) {
        if(pMap.size() != wMap.size()) {
            return false;
        }
        List<Integer> pval = new ArrayList<>(pMap.values());
        pval.sort((a,b) -> a-b);
        List<Integer> wVal = new ArrayList<>(wMap.values());
        wVal.sort((a,b) -> a-b);
        for(int i = 0; i<pval.size(); i++) {
            int pvall = pval.get(i);
            int wvall = wVal.get(i);
            if(pvall != wvall) {
                return false;
            }
        }
        return true;
    }
    public static boolean checkOrder(String w, String p, Map<Character, Integer> wMap, Map<Character, Integer> pMap) {
        for(int i = 0; i<w.length(); i++) {
            char wch = w.charAt(i);
            char pch = p.charAt(i);
            int wval = wMap.get(wch);
            int pval = pMap.get(pch);
            if(wval != pval) {
                return false;
            }
            wval = wval -1;
            if(wval == 0) {
                wMap.remove(wch);
            } else {
                wMap.put(wch, wval);
            }
            pval = pval - 1;
            if(pval == 0) {
                pMap.remove(pch);
            } else {
                pMap.put(pch, pval);
            }
        }
        return pMap.isEmpty() && wMap.isEmpty();
    }
}