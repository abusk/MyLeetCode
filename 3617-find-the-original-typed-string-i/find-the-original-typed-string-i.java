class Solution {
    public int possibleStringCount(String word) {
        char prev = ' ';
        int c = 1;
        int sum = 1;
        for(char cur : word.toCharArray()) {
            if(cur == prev) {
                c += 1;
            } else {
                sum += c -1;
                c = 1;
                prev = cur;
            }
        }
        sum += c-1;
        return sum;
    }
}