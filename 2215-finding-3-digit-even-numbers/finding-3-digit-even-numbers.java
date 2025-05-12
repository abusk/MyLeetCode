class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Map<Integer, Integer> mmap = new HashMap<>();
        for(int d : digits) {
            mmap.put(d, mmap.getOrDefault(d, 0)+1);
        }
        List<Integer> lst = new ArrayList<>();
        for(int num = 100; num <= 999; num++) {
            if(num % 2 == 1) {
                continue;
            }
            Map<Integer, Integer> map = getCount(num);
            boolean take = true;
            for(var e : map.entrySet()) {
                Integer val = mmap.get(e.getKey());
                if(val == null || val < e.getValue()) {
                    take = false;
                    break;
                }
            }
            if(take) {
                lst.add(num);
            }
        }
        int[] ans = new int[lst.size()];
        int i = 0;
        for(int a : lst) {
            ans[i++] = a;
        }
        return ans;
    }
    public Map<Integer, Integer> getCount(int num) {
        Map<Integer, Integer> map = new HashMap<>();
        while(num > 0) {
            int d = num % 10;
            map.put(d, map.getOrDefault(d, 0)+1);
            num /= 10;
        }
        return map;
    }
}