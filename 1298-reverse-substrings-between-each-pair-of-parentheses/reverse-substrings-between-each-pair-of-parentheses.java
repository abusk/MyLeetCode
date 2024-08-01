class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();
        for(int i = 0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == ')') {
                while(!stack.isEmpty()) {
                    char pop = stack.pop();
                    if(pop == '(') {
                        break;
                    } else {
                        queue.offer(pop);
                    }
                }
                while(!queue.isEmpty()) {
                    stack.push(queue.poll());
                }
            } else {
                stack.push(ch);
            }
        }
        StringBuilder ans = new StringBuilder();
        while(!stack.isEmpty()) {
            ans.append(stack.pop());
        }
        return ans.reverse().toString();
    }
}