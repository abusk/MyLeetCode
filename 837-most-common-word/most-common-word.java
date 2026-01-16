class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.split("[ !?'\",;\\.]+");

        List<String> bb = Arrays.asList(banned);
        Map<String, Integer> map = new HashMap<>();
        for(String w : words) {
            String found = w.toLowerCase(); 
            if(!bb.contains(found)) {
                map.put(found, map.getOrDefault(found, 0)+1);
            }
        }
        int max = 0;
        String ans = "";
        for(var en : map.entrySet()) {
            if(max < en.getValue()) {
                max = en.getValue();
                ans = en.getKey();
            }
        }
        return ans;
    }
}