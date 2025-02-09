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
        long all = 0;
        boolean used = false;
        for(int i = 1; i<l; i++) {
            if(all >= Integer.MAX_VALUE - i && !used) {
                all -= dd;
                all += i;
                used = true;
            } else {
                all += i;
            }
        }
        if(!used) {
            all -= dd;
        }
    
        System.out.println(all);
        System.out.println(dd);
        return all;
    }
}