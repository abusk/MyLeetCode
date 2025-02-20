class Solution {
    public String findDifferentBinaryString(String[] nums) {
        List<String> lst = new ArrayList<>();

        f(new StringBuilder(), nums[0].length(), new HashSet<>(Arrays.asList(nums)), lst);
        return lst.get(0);
    }
    public void f(StringBuilder sb, int len, Set<String> st, List<String> lst) {
        if(lst.size() > 0) {
            return;
        }
        if(sb.length() == len) {
            if(!st.contains(sb.toString())) {
                lst.add(sb.toString());
            }
            return;
        }
        StringBuilder ssb1 = new StringBuilder(sb.toString());
        f(ssb1.append('0'), len, st, lst);
        StringBuilder ssb2 = new StringBuilder(sb.toString());
        f(ssb2.append('1'), len, st, lst);
    }
}