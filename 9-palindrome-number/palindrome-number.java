class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }
        List<Integer> lst = new ArrayList<>();
        while (x > 0) {
            int ld = x % 10;
            lst.add(ld);
            x = x / 10;
        }
        int s = 0;
        int e = lst.size()-1;
        while (s < e) {
            if(lst.get(s) != lst.get(e)) {
                return false;
            }
            s++;
            e--;
        }
        return true;
    }
}