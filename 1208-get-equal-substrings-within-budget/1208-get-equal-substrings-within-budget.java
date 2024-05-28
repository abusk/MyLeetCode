// class Solution {
//     public int equalSubstring(String s, String t, int maxCost) {
//         int maxCount = 0;
//         for(int i = 0; i<s.length(); i++) {
//            maxCount = Math.max(maxCount, getLength(s.substring(i), t.substring(i), maxCost));
//         }
//         return maxCount;
//     }
//     public int getLength(String s, String t, int maxCost) {
//         int count = 0;
//         for (int i = 0; i<s.length(); i++){
//             char st = s.charAt(i);
//             char te = t.charAt(i);
//             if(st == te) {
//                 count++;
//             } else {
//                 int diff = Math.abs(st - te);
//                 maxCost -= diff;
//                 if(maxCost < 0) {
//                     break;
//                 } else {
//                     count++;
//                 }
//             }
//         }
//         return count;
//     }
// }

class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int N = s.length();
        
        int maxLen = 0;
        // Starting index of the current substring
        int start = 0;
        // Cost of converting the current substring in s to t
        int currCost = 0;
        
        for (int i = 0; i < N; i++) {
            // Add the current index to the substring
            currCost += Math.abs(s.charAt(i) - t.charAt(i));
            
            // Remove the indices from the left end till the cost becomes less than allowed
            while (currCost > maxCost) {
                currCost -= Math.abs(s.charAt(start) - t.charAt(start));
                start++;
            }
            
            maxLen = Math.max(maxLen, i - start + 1);
        }
        
        return maxLen;
    }
}