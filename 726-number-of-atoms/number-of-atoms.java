class Solution {
    public String countOfAtoms(String formula) {
        Stack<String> st = new Stack<>();
        Stack<String> tmpStack = new Stack<>();
        int l = formula.length();
        for(int i = 0; i<formula.length(); i++) {
            if(formula.charAt(i) == '(') {
                st.push("(");
            } else if(formula.charAt(i) >= 65 && formula.charAt(i) <= 90) {
                String e = "" + formula.charAt(i);
                while(i < l-1 
                && ((formula.charAt(i + 1) >= 97 && formula.charAt(i+1) <= 122) 
                || Character.isDigit(formula.charAt(i + 1)))) {
                    e += formula.charAt(i+1);
                    i++;
                }
                st.push(getStackString(e));
            } else if(formula.charAt(i) == ')') {
                String d = "";
                while(i < l-1 && Character.isDigit(formula.charAt(i+1))) {
                    d += formula.charAt(i+1);
                    i++;
                }
                int pw = 1;
                if (!d.isEmpty()) {
                    pw = Integer.parseInt(d);
                }
                while(!st.isEmpty()) {
                    String pop = st.pop();
                    if(pop.equals("(")) {
                        break;
                    } else {
                        String [] split = pop.split("[-]");
                        int epw = Integer.parseInt(split[1]);
                        int npw = epw * pw;
                        String npop = split[0] + "-" + npw;
                        tmpStack.push(npop);
                    }
                }
                while(!tmpStack.isEmpty()) {
                    st.push(tmpStack.pop());
                }
            }
        }
        Map<String, Integer> map = new HashMap<>();
        while(!st.isEmpty()) {
            String [] split = st.pop().split("[-]");
            map.put(split[0], map.getOrDefault(split[0], 0) + Integer.parseInt(split[1]));
        }
        List<String> lst = new ArrayList<>();
        for(var entry : map.entrySet()) {
            String item = entry.getKey();
            if(entry.getValue() > 1) {
                item += entry.getValue();
            }
            lst.add(item);
        }
        lst.sort((a,b) -> a.compareTo(b));
        String ans = "";
        for(String a : lst) {
            ans += a;
        }
        return ans;
    }
    public String getStackString(String sub) {
        String elem = "";
        String digit = "";
        for(int i= 0; i<sub.length(); i++) {
            if(Character.isDigit(sub.charAt(i))) {
                digit += sub.charAt(i);
            } else {
                elem += sub.charAt(i);
            }
        }
        if(digit.isEmpty()) {
            return elem + "-" + "1";
        }
        return elem + "-" + digit;
    }
}