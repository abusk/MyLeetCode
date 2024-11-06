class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new HashMap<>();
        for(int i =0; i<s.length()-10+1; i++) {
            String a = s.substring(i, i+10);
            map.put(a, map.getOrDefault(a, 0) +1);
        }
        List<String> ans = new ArrayList<>();
        for(var entry : map.entrySet()) {
            if(entry.getValue() > 1) {
                ans.add(entry.getKey());
            }
        }
        return ans;
    }
}