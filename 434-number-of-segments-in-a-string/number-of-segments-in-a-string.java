class Solution {
    public int countSegments(String s) {
        String[] split = s.split(" ");
        int c = 0;
        for(String a : split) {
            if(!a.equals(" ") && !a.equals("")) {
                c++;
            }
        }
        return c;
    }
}