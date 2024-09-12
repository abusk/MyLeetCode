class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> st = new HashSet<>();
        for(int i = 0; i<allowed.length(); i++) {
            st.add(allowed.charAt(i));
        }
        int c = 0;
        for(String word : words) {
            boolean f = true;
            for(int i = 0; i<word.length(); i++) {
                if(!    st.contains(word.charAt(i))) {
                    f = false;
                }
            }
            if(f) {
                c++;
            }
        }
        return c;
    }
}