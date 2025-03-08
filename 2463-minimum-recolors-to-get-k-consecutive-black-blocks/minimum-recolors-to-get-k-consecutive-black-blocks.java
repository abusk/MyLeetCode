class Solution {
    public static int minimumRecolors(String blocks, int k) {
        int j = 0;
        int ans = 0;
        int c = 0;
        for(; j<k; j++) {
            if(blocks.charAt(j) == 'W') {
                c++;
            }
        }
        ans = c;
        int start = 0;
        for(int end = j; end<blocks.length(); end++) {
            if(blocks.charAt(end) == 'W') {
                c++;
            }
            if(blocks.charAt(start) == 'W'){
                c--;
            }
            start++;
            ans = Math.min(ans, c);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minimumRecolors("B", 1));
    }
}