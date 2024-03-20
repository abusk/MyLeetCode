class Solution {
    public int longestConsecutive(int[] nums) {
        boolean [] visited = new boolean[nums.length];
        Map<Integer, Pair<Integer, Integer>> next = new HashMap<>();
        Map<Integer, Pair<Integer, Integer>> prev = new HashMap<>();
        for(int i = 0; i<nums.length; i++) {
            next.put(nums[i], new Pair(nums[i]+1, i));
            prev.put(nums[i], new Pair(nums[i]-1, i));
        }
        int mx = 0;
        for(int i = 0; i<nums.length; i++){
            if(!visited[i]){
                int l = 0;
                int r = 0;
                int n = nums[i];
                while(true){
                    if(next.get(n) != null){
                        Pair<Integer, Integer> p = next.get(n);
                        n = p.getKey();
                        visited[p.getValue()] = true;
                        l++;
                    } else{
                        break;
                    }
                }
                int m = nums[i];
                while(true){
                    if(next.get(m) != null){
                        Pair<Integer, Integer> p = prev.get(m);
                        m = p.getKey();
                        visited[p.getValue()] = true;
                        r++;
                    } else{
                        break;
                    }
                }
                mx = Math.max(mx, (l+r-1));
            }
        }
        return mx;
    }
}