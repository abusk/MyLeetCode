class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()) {
            if(st.isEmpty() || ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else {
                char peek = st.peek();
                if((ch == ')' && peek == '(') || (ch == '}' && peek == '{') || (ch == ']' && peek == '[')) {
                    st.pop();
                } else {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}