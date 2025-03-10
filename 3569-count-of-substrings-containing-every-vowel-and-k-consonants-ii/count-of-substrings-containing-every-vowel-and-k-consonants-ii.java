class Solution {
    public static long countOfSubstrings(String word, int k) {
        return atLeastK(word, k) - atLeastK(word, k+1);
    }
    public static long atLeastK(String word, int k) {
        Map<Character, Integer> map = new HashMap<>();
        List<Character> vo = Arrays.asList('a', 'e', 'i', 'o', 'u');
        for (char v : vo) {
            map.put(v, 0);
        }

        long ans = 0;
        int conso = 0;
        int start = 0;
        int end = 0;
        while(end < word.length()) {
            char ch = word.charAt(end);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                conso++;
            }
            while (voCondition(map) && conso >= k) {
                ans += word.length() - end;
                char chs = word.charAt(start);
                if (map.containsKey(chs)) {
                    map.put(chs, map.get(chs) - 1);
                } else {
                    conso--;
                }
                start++;
            }
            end++;
        }
        return ans;

    }
    public static boolean voCondition(Map<Character, Integer> map) {
        for(var entry : map.entrySet()) {
            if(entry.getValue() < 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(countOfSubstrings("abebaoiudek", 2));
    }
}