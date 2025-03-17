class Solution {
    public boolean divideArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums) {
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        for(int a : map.values()) {
            if(a%2 != 0) {
                return false;
            }
        }
        return true;
    }
}