class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();
        for(char ch : s.toCharArray()) {
            if(ch == '#') {
                if(!st1.isEmpty()) {
                    st1.pop();
                }
            } else {
                st1.push(ch);
            }
        }
        for(char ch : t.toCharArray()) {
            if(ch == '#') {
                if(!st2.isEmpty()) {
                    st2.pop();
                }
            } else {
                st2.push(ch);
            }
        }

        while (!st1.isEmpty() && !st2.isEmpty()) {
            char ch1 = st1.pop();
            char ch2 = st2.pop();
            if(ch1 != ch2) {
                return false;
            }
        }
        if(!st1.isEmpty() || !st2.isEmpty()) {
            return false;
        }
        return true;
    }
}