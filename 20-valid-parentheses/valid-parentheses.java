class Solution {
    public boolean isValid(String s) {
        boolean flag = false;
        Stack<Character> st = new Stack<>();
        for(int i = 0; i<s.length(); i++){
            char a = s.charAt(i);
            if (st.isEmpty() && (a == ')' || a == '}' || a == ']')) 
                return false;
            if(a == ')' && st.pop() == '(') {
                flag = true;
            } else if(a == '}' && st.pop() == '{') {
                flag = true;
            } else if(a == ']' && st.pop() == '[') {
                flag = true;
            } else {
                flag = false;
                st.push(a);
            }
        }
        if(flag && st.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}