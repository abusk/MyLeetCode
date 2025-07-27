class Solution {
    public int countHillValley(int[] nums) {
        List<Integer> lst = new ArrayList<>();
        for(int num : nums) {
            if(lst.size() == 0) {
                lst.add(num);
            } else {
                if(lst.getLast() == num) {
                    continue;
                } else {
                    lst.add(num);
                }

            }
        }
        if(lst.size() < 3) {
            return 0;
        }
        int ans =0;
        for(int i = 1; i<lst.size()-1; i++) {
            if((lst.get(i) > lst.get(i-1) && lst.get(i) > lst.get(i+1)) || (lst.get(i) < lst.get(i-1) && lst.get(i) < lst.get(i+1))) {
                ans++;
            }
        }
        return ans;
    }
}