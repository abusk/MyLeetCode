class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for(int candie : candies) {
            max = Math.max(max, candie);
        }
        List<Boolean> ans = new ArrayList<>();
        for(int candie : candies) {
            if(max <= (candie + extraCandies)) {
                ans.add(true);
            } else {
                ans.add(false);
            }
        }
        return ans;
    }
}