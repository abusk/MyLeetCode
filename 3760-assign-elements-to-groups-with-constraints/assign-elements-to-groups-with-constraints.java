class Solution {
    public int[] assignElements(int[] groups, int[] elements) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> map1 = new HashMap<>();
        List<Integer> nums = new ArrayList<>();
        for(int i = 0; i< elements.length; i++) {
            if(!map.containsKey(elements[i])) {
                map.put(elements[i], i);
                nums.add(elements[i]);
            }
        }
        
        
        int[] ans = new int[groups.length];
        for(int j = 0; j<groups.length; j++) {
            ans[j] = -1;
        }
        for(int j = 0; j<groups.length; j++) {
            if(map1.containsKey(groups[j])) {
                ans[j] = map1.get(groups[j]);
            } else {
                int optIdx = Integer.MAX_VALUE;
                for(int num = 1; num * num <= groups[j];  num++) {
                    if(groups[j] % num == 0) {
                        if(map.containsKey(num)) {
                            optIdx = Math.min(optIdx, map.get(num));
                        }
                        if(map.containsKey(groups[j] /num)) {
                            optIdx = Math.min(optIdx, map.get(groups[j] /num));
                        }
                    }
                }
                if(optIdx != Integer.MAX_VALUE) {
                    map1.put(groups[j], optIdx);
                    ans[j] = optIdx;
                }
            
            }
            
        }
        return ans;
    }
}