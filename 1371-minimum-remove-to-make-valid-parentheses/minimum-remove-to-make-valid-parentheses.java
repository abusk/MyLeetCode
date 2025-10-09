class Solution {
    /**
     * 3ge3uv
     */
    public record PIR(char paren, int index){}
    public String minRemoveToMakeValid(String s) {
        Stack<PIR> st = new Stack<>();
        for(int i = 0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                st.push(new PIR(ch, i));
            } else if(ch == ')') {
                if(st.isEmpty()) {
                    st.push(new PIR(ch, i));
                } else {
                    if(st.peek().paren == '(') {
                        st.pop();
                    } else {
                        st.push(new PIR(ch, i));
                    }
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        for(PIR p : st) {
            set.add(p.index);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<s.length(); i++) {
            if(!set.contains(i)) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}