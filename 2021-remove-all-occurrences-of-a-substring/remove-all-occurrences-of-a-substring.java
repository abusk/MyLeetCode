class Solution {
    public String removeOccurrences(String s, String part) {
        int sl = s.length();
        int pl = part.length();
        while(s.indexOf(part) != -1) {
            int id = s.indexOf(part);
            if(id == 0) {
                s = s.substring(pl);
            } else {
                s = s.substring(0, id) + s.substring(id + pl);
            }
        }
        return s;
    }
}