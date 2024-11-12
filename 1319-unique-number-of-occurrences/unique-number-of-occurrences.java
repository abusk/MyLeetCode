class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int a : arr) {
            map.put(a, map.getOrDefault(a, 0)+1);
        }
        Set<Integer> st = new HashSet<>();
        for(var entry : map.entrySet()) {
            if(st.contains(entry.getValue())) {
                return false;
            } else {
                st.add(entry.getValue());
            }
        }
        return true;
    }
}