class Solution {
    public boolean reorderedPowerOf2(int n) {
        int mm = max(n);
        int pn = 1;
        while(pn <= mm) {
            if(check(pn, n)) {
                return true;
            }
            pn = pn << 1;
        }
        return false;
    }
    public boolean check(int pn, int n) {
        List<Integer> lst1 = new ArrayList<>();
        List<Integer> lst2 = new ArrayList<>();
        while(pn > 0) {
            int rem = pn % 10;
            lst1.add(rem);
            pn /= 10;
        }
        while(n > 0) {
            int rem = n % 10;
            lst2.add(rem);
            n /= 10;
        }
        lst1.sort((a,b) -> b-a);
        lst2.sort((a,b) -> b-a);
        return lst1.equals(lst2);
    }
    public int max(int n) {
        List<Integer> lst1 = new ArrayList<>();
        while(n > 0) {
            int rem = n % 10;
            lst1.add(rem);
            n /= 10;
        }
        lst1.sort((a,b) -> b-a);
        int mnum = 0;
        for(int a : lst1) {
            mnum = mnum * 10 + a;
        }
        return mnum;
    }
}