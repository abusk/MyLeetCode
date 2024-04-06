class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Pair<Character, Integer>> st = new Stack<>();
        for(int i = 0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                st.push(new Pair('(', i));
            } else if(s.charAt(i) == ')') {
                if(st.isEmpty()) {
                    st.push(new Pair(')', i));
                } else if(st.peek().getKey() == '(') {
                    st.pop();
                } else {
                    st.push(new Pair(')', i));
                }
            }
        }
        Set<Integer> dset = new HashSet<>();
        while(!st.isEmpty()) {
           dset.add(st.pop().getValue()); 
        }
        StringBuilder res = new StringBuilder();
        for(int i = 0; i<s.length(); i++) {
            if(!dset.contains(i)) {
               res.append(s.charAt(i)); 
            }
        }
        return res.toString();
    }
}