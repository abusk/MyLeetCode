class Solution {
    public static List<Integer> solveQueries(int[] nums, int[] queries) {
        int len = nums.length;

        int[] nnums = new int[2 * len];
        int k = 0;
        for (int n : nums) {
            nnums[k++] = n;
        }
        for (int i = 0; i < len; i++) {
            nnums[k++] = nums[i];
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i< 2 * len; i++) {
            int nm = nnums[i];
            List<Integer> lst = map.getOrDefault(nm, new ArrayList<>());
            lst.add(i);
            map.put(nm, lst);
        }
        int ql = queries.length;
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < ql; i++) {
            int q = queries[i];
            if(q < 0 || q >= nums.length) {
                ans.add(-1);
                continue;
            }
            int nm = nums[q];
            if(map.get(nm).size() <= 2) {
                ans.add(-1);
                continue;
            }
            List<Integer> lst = map.get(nm);
            int ind1 = Collections.binarySearch(lst, q);
            int ind2 = Collections.binarySearch(lst, q+len);
            int nxt1 = lst.get(ind1+1) - q;
            int nxt2 = q + len - lst.get(ind2-1);
            ans.add(Math.min(nxt1, nxt2));
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2,10,20,20,20};
        int q[] = {1, 4, 2};
        List<Integer> ans = solveQueries(nums, q);
    }
}