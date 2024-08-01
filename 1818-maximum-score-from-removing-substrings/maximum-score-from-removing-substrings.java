// class Solution {
//     public int maximumGain(String s, int x, int y) {
//         Stack<Character> st1 = new Stack<>();
//         char c1;
//         char c2;
//         int m =0;
//         int n = 0;
//         if(x >= y) {
//             c1 = 'a';
//             c2 = 'b';
//             m = x;
//             n =y;
//         } else {
//             c1 = 'b';
//             c2 = 'a';
//             m = y;
//             n = x;
//         }
//         int max = 0;
//         for(int i = 0; i<s.length(); i++) {
//             if(st1.isEmpty() || s.charAt(i) != c2) {
//                 st1.push(s.charAt(i));
//             } else if(s.charAt(i) == c2) {
//                 if(st1.peek() == c1) {
//                     st1.pop();
//                     max += m;
//                 } else {
//                     st1.push(s.charAt(i));
//                 }
//             } 
//         }
//         while(!st1.isEmpty()) {
//             char ch = st1.pop();
//             if(!st1.isEmpty() && ch == c1 && st1.peek() ==c2) {
//                 st1.pop();
//                 max += n;
//             } 
//         }
//         return max;
//     }
// }

class Solution {

    public int maximumGain(String s, int x, int y) {
        int totalScore = 0;
        String highPriorityPair = x > y ? "ab" : "ba";
        String lowPriorityPair = highPriorityPair.equals("ab") ? "ba" : "ab";

        // First pass: remove high priority pair
        String stringAfterFirstPass = removeSubstring(s, highPriorityPair);
        int removedPairsCount =
            (s.length() - stringAfterFirstPass.length()) / 2;

        // Calculate score from first pass
        totalScore += removedPairsCount * Math.max(x, y);

        // Second pass: remove low priority pair
        String stringAfterSecondPass = removeSubstring(
            stringAfterFirstPass,
            lowPriorityPair
        );
        removedPairsCount = (stringAfterFirstPass.length() -
            stringAfterSecondPass.length()) /
        2;

        // Calculate score from second pass
        totalScore += removedPairsCount * Math.min(x, y);

        return totalScore;
    }

    private String removeSubstring(String input, String targetPair) {
        Stack<Character> charStack = new Stack<>();

        // Iterate through each character in the input string
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            // Check if current character forms the target pair with the top of the stack
            if (
                currentChar == targetPair.charAt(1) &&
                !charStack.isEmpty() &&
                charStack.peek() == targetPair.charAt(0)
            ) {
                charStack.pop(); // Remove the matching character from the stack
            } else {
                charStack.push(currentChar);
            }
        }

        // Reconstruct the remaining string after removing target pairs
        StringBuilder remainingChars = new StringBuilder();
        while (!charStack.isEmpty()) {
            remainingChars.append(charStack.pop());
        }
        return remainingChars.reverse().toString();
    }
}