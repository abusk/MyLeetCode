class Solution {
    public long countBadPairs(int[] nums) {
        int l = nums.length;
        long [] a = new long[l];

        for(int i =0; i<l; i++) {
            a[i] = i - nums[i];
        }
        Map<Long, Long> map = new HashMap<>();
        for(int i =0; i<l; i++) {
            map.put(a[i], map.getOrDefault(a[i], 0L)+1);
        }
        long dd = 0;
        List<Long> values = new ArrayList<>(map.values());
        for(long v : values) {
            if(v <= 1) continue;
            dd += (v * (v-1) /2);
        }
        long ll = (long)l;
        long all = (ll * (ll-1) /2L);

        return all-dd;
    }
}