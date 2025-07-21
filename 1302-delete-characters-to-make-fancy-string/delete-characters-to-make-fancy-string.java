class Solution {
    public record Pair(char ch, int count){}
    public String makeFancyString(String s) {
        Stack<Pair> st = new Stack<>();
        for(char ch : s.toCharArray()) {
            if(st.isEmpty()) {
                Pair p = new Pair(ch, 1);
                st.push(p);
            } else {
                Pair peek = st.peek();
                if(ch != peek.ch) {
                    Pair p = new Pair(ch, 1);
                    st.push(p); 
                } else if(ch == peek.ch && peek.count < 2){
                    Pair p = new Pair(ch, peek.count+1);
                    st.push(p); 
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(Pair p : st) {
            sb.append(p.ch);
        }
        return sb.toString();
    }
}