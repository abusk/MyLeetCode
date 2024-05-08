class Solution {
    public String[] findRelativeRanks(int[] score) {
        int[] dup = score.clone();
        Arrays.sort(dup);
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< score.length; i++) {
            map.put(dup[i], i);
        }
        String[] ans = new String[score.length];
        int k = 0;
        for(int i = 0; i < score.length; i++) {
            int ind = map.get(score[i]);
            if(ind == score.length-1) {
                ans[k++] = "Gold Medal";
            } else if(ind == score.length-2) {
                ans[k++] = "Silver Medal";
            } else if(ind == score.length-3) {
                ans[k++] = "Bronze Medal";
            } else {
                ans[k++] = "" + (score.length - ind);
            }
        }
        return ans;
    }
}