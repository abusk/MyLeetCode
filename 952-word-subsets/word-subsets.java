class Solution {

    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] bmax = count("");
        for (String b : words2) {
            int[] bCount = count(b);
            for (int i = 0; i < 26; ++i) bmax[i] = Math.max(bmax[i], bCount[i]);
        }

        List<String> ans = new ArrayList();
        search: for (String a : words1) {
            int[] aCount = count(a);
            for (int i = 0; i < 26; ++i) if (
                aCount[i] < bmax[i]
            ) continue search;
            ans.add(a);
        }

        return ans;
    }

    public int[] count(String S) {
        int[] ans = new int[26];
        for (char c : S.toCharArray()) ans[c - 'a']++;
        return ans;
    }
}