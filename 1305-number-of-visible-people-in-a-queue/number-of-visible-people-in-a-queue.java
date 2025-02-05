class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int len = heights.length;
        int[] ans = new int[len];
        Stack<Integer> stack = new Stack<>();
        for(int i = len-1; i>=0; i--) {
            int num = heights[i];
            int count = 0;
            while (!stack.isEmpty() && stack.peek() < num) {
                stack.pop();
                count++;
            }
            if(!stack.isEmpty()) {
                count++;
            }
            ans[i] = count;
            stack.push(num);
        }
        return ans;
    }
}