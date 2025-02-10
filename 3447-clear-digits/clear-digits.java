class Solution {
    public String clearDigits(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                st.pop();
            } else {
                st.push(ch);
            }
        }

        String ans = "";
        while(!st.isEmpty()) {
            ans = st.pop() + ans;
        }
        return ans;
    }
}