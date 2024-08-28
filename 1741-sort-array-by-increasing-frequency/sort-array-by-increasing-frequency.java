class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map= new HashMap<>();
        for(int i = 0; i< nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        List<int[]> lst = new ArrayList<>();
        for(var entry : map.entrySet()) {
            lst.add(new int[] {entry.getKey(), entry.getValue()});
        }
        lst.sort((a,b) -> {
            if(a[1] == b[1]) {
                return b[0] - a[0];
            } else {
                return a[1] - b[1];
            }
        });
        int[] ans = new int[nums.length];
        int j = 0;
        for(int i =0; i<lst.size(); i++) {
            int c = lst.get(i)[1];
            while (c > 0) {
                ans[j++] = lst.get(i)[0];
                c--;
            }
        }
        return ans;
    }
}