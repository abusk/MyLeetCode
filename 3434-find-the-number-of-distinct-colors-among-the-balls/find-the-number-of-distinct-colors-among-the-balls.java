class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[queries.length];
        int i = 0;
        Map<Integer, Integer> colors = new HashMap<>();
        for(int[] query : queries) {
            if(map.containsKey(query[0])) {
                int color = map.get(query[0]);
                int cval = colors.get(color) -1;
                if(cval == 0) {
                    colors.remove(color);
                } else {
                    colors.put(color, cval);
                }
            }
            map.put(query[0], query[1]);
            colors.put(query[1], colors.getOrDefault(query[1], 0)+1);

            ans[i++] = colors.size();
        }
        return ans;
    }
}