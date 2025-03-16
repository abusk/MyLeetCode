class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Pair<Character, Integer>> st = new Stack<>();
        StringBuilder sb = new StringBuilder(s);
        for(int i = 0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                st.push(new Pair<>(ch, i));
            } else if(ch == ')') {
                if(!st.isEmpty() && st.peek().getKey() == '('){
                    st.pop();
                } else {
                    st.push(new Pair<>(ch, i));
                }
                
            }
        }
        for(Pair<Character, Integer> p : st) {
            sb.setCharAt(p.getValue(), '#');
        }

        return sb.toString().replace("#", "");
    }
}