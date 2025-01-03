class Solution {
    public int maxPotholes(String road, int budget) {
        List<Integer> lst = getConsecutives(road);
        lst.sort((a, b) -> b - a);
        int ans = 0;
        for(int p : lst) {
           if (budget <= 1) break;
            if (p + 1 <= budget) {
                budget -= p + 1;
                ans += p;
            } else {
                ans += budget - 1;
                budget = 0;
            }
        }
        return ans;
    }
    public List<Integer> getConsecutives(String road) {
        List<Integer> lst = new ArrayList<>();
        int cur = 0;
        for (int i = 0; i < road.length(); i++) {
            boolean isHole = road.charAt(i) == 'x';
            if (isHole) {
                cur++;
            } else {
                if (cur > 0) lst.add(cur);
                cur = 0;
            }
        }
        if (cur > 0) lst.add(cur);
        return lst;
    }
}