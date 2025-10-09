class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int wl = word.length();
        int al = abbr.length();
        int ai = 0;
        int wi = 0;
        while(ai < al && wi < wl) {
            char wch = word.charAt(wi);
            char ach = abbr.charAt(ai);
            if(!Character.isDigit(ach)) {
                if(wch != ach) {
                    return false;
                } else {
                    ai++;
                    wi++;
                    continue;
                }
            } else {
                if(ach == '0') {
                    return false;
                }
                int num = 0;
                while(ai < al && Character.isDigit(abbr.charAt(ai))) {
                    num = num * 10 + (abbr.charAt(ai) - '0');
                    ai++;
                }
                wi += num;
            }
        }
        return wi == wl && ai == al;
    }
}