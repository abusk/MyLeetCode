class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i<nums.length; i++) {
            int mappedV = mapped(mapping, nums[i]);
            List<Integer> lst = map.getOrDefault(mappedV, new ArrayList<>());
            lst.add(nums[i]);
            map.put(mappedV, lst);
        }
        List<Integer> keys = new ArrayList<>(map.keySet());
        keys.sort((a, b)-> a.compareTo(b));
        int[] res = new int[nums.length];
        int c = 0;
        for(int k : keys) {
            List<Integer> vs = map.get(k);
            for(int v : vs) {
                res[c++] = v;
            }
        }
        return res;
    }
    private int mapped(int[] mapping, int num) {
        int dec = 1;
        int newNum = 0;
        if(num == 0) {
            newNum = mapping[num];
        } else {
            while(num != 0) {
                int r = num % 10;
                int nr = mapping[r];
                newNum += nr* dec;
                num /= 10;
                dec *= 10;
            }
        }
        return newNum;
    }
}