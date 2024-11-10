class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() == goal.length()) {
            s = s.repeat(2);
            return s.contains(goal);
        }
        return false;
    }
}