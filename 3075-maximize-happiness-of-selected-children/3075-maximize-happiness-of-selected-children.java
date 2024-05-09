class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b) -> b-a);
        for(int i = 0; i<happiness.length; i++) {
            q.add(happiness[i]);
        }
        int nd = 0;
        long ans = 0;
        while(k > 0) {
            int v = q.poll() - nd;
            if(v <= 0) {
                return ans;
            }
            ans += v;
            nd++;
            k--;
        }
        return ans;
    }
}