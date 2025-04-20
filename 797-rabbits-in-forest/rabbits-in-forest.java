class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        int z = 0;
        for(int a : answers) {
            if(a == 0) {
                z++;
                continue;
            }
            map.put(a, map.getOrDefault(a, 0)+1);
        }
        int ans = z;
        while(!map.isEmpty()) {
            var entry = map.entrySet().iterator().next();
            int key = entry.getKey();
            int val = entry.getValue();
            ans += people(map, key, val);
        }
        return ans;
    }
    public int people(Map<Integer, Integer> map, int key, int val) {
        if(key+1 >= val) {
            map.remove(key);
        } else {
            map.put(key, map.get(key) - key -1);
        }
        return key + 1;
    }
}