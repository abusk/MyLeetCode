class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        Set<String> mpd = new HashSet<>();
        String [] words = s.split(" ");
        if(pattern.length() != words.length) {
            return false;
        }
        for(int i = 0; i<pattern.length(); i++) {
            char p = pattern.charAt(i);
            if(map.containsKey(p) && !words[i].equals(map.get(p))) {
                return false;
            }
            if(!map.containsKey(p) && mpd.contains(words[i])) {
                return false;
            }
            if(!map.containsKey(p)) {
                map.put(p, words[i]);
                mpd.add(words[i]);
            }
            
        }
        return true;
    }
}