// class Solution {
//     public int largestRectangleArea(int[] heights) {
//         Stack<int[]> stack = new Stack<>();
//         int max = 0;
//         for(int i= 0; i<heights.length; i++) {
//             int item = heights[i];
//             if(stack.isEmpty()) {
//                 stack.push(new int[]{item, i});
//             } else {
//                 int[] seek = stack.peek();
//                 if(item>=seek[0]) {
//                     stack.push(new int[]{item, i});
//                 } else {
//                     int last = seek[1];
//                     while(!stack.isEmpty() || item < seek[0]) {
//                         max = Math.max(max, seek[0] * (last - seek[1] +1));
//                         stack.pop();
//                         seek = stack.peek();
//                     }
//                     stack.push(new int[]{item, i});
//                 }
//             }
//         }
//         while(!stack.isEmpty()) {
//             int last = seek[1];
//             while(!stack.isEmpty() || item < seek[0]) {
//                 max = Math.max(max, seek[0] * (last - seek[1] +1));
//                 stack.pop();
//                 seek = stack.peek();
//             }
//         }
//     }
// }

public class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int length = heights.length;
        int maxArea = 0;
        for (int i = 0; i < length; i++) {
            while (
                (stack.peek() != -1) && (heights[stack.peek()] >= heights[i])
            ) {
                int currentHeight = heights[stack.pop()];
                int currentWidth = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, currentHeight * currentWidth);
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            int currentHeight = heights[stack.pop()];
            int currentWidth = length - stack.peek() - 1;
            maxArea = Math.max(maxArea, currentHeight * currentWidth);
        }
        return maxArea;
    }
}