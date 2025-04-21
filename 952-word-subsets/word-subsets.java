class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] w2c = new int[26];
        for(String w2 : words2) {
            int[] tmp = new int[26];
            for(char ch : w2.toCharArray()) {
                tmp[ch -'a']++;
            }
            for(int i = 0; i<26; i++) {
                w2c[i] = Math.max(w2c[i], tmp[i]);
            }
        }
        List<String> ans = new ArrayList<>();
        for(String w1 : words1) {
            int[] tmp = new int[26];
            for(char ch : w1.toCharArray()) {
                tmp[ch -'a']++;
            }
            boolean flag = true;
            for(int i = 0; i<26; i++) {
                if(tmp[i] < w2c[i]){
                    flag = false;
                    break;
                }
            }
            if(flag) {
                ans.add(w1);
            }
        }
        return ans;
    }
}