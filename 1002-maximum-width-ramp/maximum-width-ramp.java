class Solution {
    public int maxWidthRamp(int[] nums) {
        int l = nums.length;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < l; i++) {
            if(st.isEmpty() || nums[st.peek()] > nums[i]) {
                st.push(i);
            }
        }
        int max = 0;
        for(int i = l-1; i >=0; i--) {
            while(!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                max = Math.max(max, i - st.peek());
                st.pop();
            }
        } 
        return max;
    }
}