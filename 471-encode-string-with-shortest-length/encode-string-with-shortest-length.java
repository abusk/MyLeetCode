class Solution {
    static Map<String, String> memo = new HashMap<>();
    public static String encode(String s) {
        int len = s.length();
        if(s == null || len < 5) {
            return s;
        }
        if(memo.containsKey(s)) {
            return memo.get(s);
        }
        int min = Integer.MAX_VALUE;
        String ans = s;
        for(int i = 1; i< (len/2 +1); i++) {
            String res = s;
            String left = s.substring(0, i);
            String right = s.substring(i);
            int rp = countReapet(left, right);
            String notTake = encode(left) + encode(right);
            String take = s;
            if(rp > 0) {
                take = (rp + 1) + "[" + encode(left) + "]" + encode(right.substring(rp * left.length()));
            }
            if(notTake.length() > take.length()) {
                res = take;
            } else {
                res = notTake;
            }
            if(res.length() < s.length()) {
                if(min > res.length()) {
                    min = res.length();
                    ans = res;
                }
            }
        }
        memo.put(s, ans);
        return ans;
    }
    public static int countReapet(String p, String s) {
        int c = 0;
        int start =0;
        int index = s.indexOf(p, start);
        while (index != -1) {
            int next = s.indexOf(p, start);
            if(next != start) {
                break;
            }
            index = next;
            start = start + p.length();
            c++;
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println(encode("aaaaaaaaaa"));
    }
}