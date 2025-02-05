class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        List<Integer> poss = new ArrayList<>();
        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                poss.add(i);
            }
        }
        if(poss.size() == 0) {
            return true;
        }
        if(poss.size() == 2) {
            if(s1.charAt(poss.get(0)) == s2.charAt(poss.get(1)) 
            && s2.charAt(poss.get(0)) == s1.charAt(poss.get(1))) {
            return true;
        }
        }
        return false;
    }
}