class Solution {
    public int maximumLength(int[] nums) {
        int ce = 0;
        int co = 0;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i<nums.length; i++) {
            if(nums[i] % 2 == 0) {
                ce++;
            } else {
                co++;
            }
            if(st.isEmpty()) {
                st.push(nums[i]);
            } else {
                if(st.peek() %2 != nums[i] %2) {
                    st.push(nums[i]);
                }
            }
        }
        return Math.max(Math.max(ce, co), st.size());
    }
}