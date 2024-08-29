class Solution {
    public int findTheWinner(int n, int k) {
        List<Integer> lst = new ArrayList<>();
        for(int i = 0; i<n; i++) {
            lst.add(i+1);
        }
        int s = 0;
        int t = 0;
        while (lst.size() > 1) {
            int l = lst.size();
            t = (s + k-1) % l;
            lst.remove(t);
            s = t;
        }
        return lst.get(0);
    }
}