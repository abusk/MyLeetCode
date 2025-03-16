class Solution {
    record Pair(Character key, Integer val) {}
    public static String minRemoveToMakeValid(String s) {
        Stack<Pair> st = new Stack<>();
        for(int i = 0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                st.push(new Pair(ch, i));
            } else if(ch == ')') {
                if (!st.isEmpty() && st.peek().key == '(') {
                    st.pop();
                } else {
                    st.push(new Pair(ch, i));
                }
            }
        }
        StringBuilder sb = new StringBuilder(s);
        for (Pair p : st) {
            sb.setCharAt(p.val, '#');
        }
        return sb.toString().replace("#", "");
    }

    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
    }
}