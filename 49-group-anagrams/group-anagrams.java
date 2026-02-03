class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for( String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> lst = map.getOrDefault(key, new ArrayList<>());
            lst.add(str);
            map.put(key, lst);
        }
        List<List<String>> ans = new ArrayList<>();
        for( var e : map.entrySet()) {
            ans.add(e.getValue());
        }
        return ans;
    }
}