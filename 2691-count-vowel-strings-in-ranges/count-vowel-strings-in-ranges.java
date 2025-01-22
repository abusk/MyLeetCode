class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        Set<Character> vow = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int [] ps = new int[words.length];
        int sum = 0;
        for(int i = 0; i < words.length; i++) {
            if(isValid(words[i], vow)) {
                sum += 1;
            }
            ps[i] = sum;
        }
        int ans[] = new int[queries.length];
        for(int i = 0; i<queries.length; i++) {
            int[] q = queries[i];
            int f = q[0] -1;
            int l = q[1];
            if(f < 0) {
                ans[i] = ps[l];
            } else {
                ans[i] = ps[l] - ps[f];
            }
        }
        return ans;
    }
    public boolean isValid(String word, Set<Character> vow) {
        if (vow.contains(word.charAt(0)) && vow.contains(word.charAt(word.length() -1))) {
            return true;
        }
        return false;
    }
}