class Solution {
    public boolean isAnagram(String s, String t) {
        int [] cc = new int [26];
        for(int i = 0; i<s.length(); i++) {
            char ch = s.charAt(i);
            cc[ch - 'a']++;
        }
        for(int i= 0; i<t.length(); i++) {
            char ch = t.charAt(i);
            cc[ch - 'a']--;
        }
        for(int i = 0; i<26; i++) {
            if(cc[i] != 0) {
                return false;
            }
        }
        return true;
    }
}