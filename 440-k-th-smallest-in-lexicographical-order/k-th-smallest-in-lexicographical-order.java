// class Solution {
//     public int findKthNumber(int n, int k) {
//         PriorityQueue<String> pq = new PriorityQueue<>(
//             (a, b) -> {
//                 if(a.length() == b.length()) {
//                     for(int i = 0; i<a.length(); i++) {
//                         if(a.charAt(i) > b.charAt(i)) {
//                             return 1;
//                         }
//                         if(a.charAt(i) < b.charAt(i)) {
//                             return -1;
//                         }
//                     }
//                     return 0;
//                 } else if(a.length() > b.length()) {
//                     for(int i = 0; i<b.length(); i++) {
//                         if(a.charAt(i) > b.charAt(i)) {
//                             return 1;
//                         }
//                         if(a.charAt(i) < b.charAt(i)) {
//                             return -1;
//                         }
//                     }
//                     return 1;
//                 } else {
//                     for(int i = 0; i<a.length(); i++) {
//                         if(a.charAt(i) > b.charAt(i)) {
//                             return 1;
//                         }
//                         if(a.charAt(i) < b.charAt(i)) {
//                             return -1;
//                         }
//                     }
//                     return -1;
//                 }
//             }
//         );
//         for(int i = 1; i<=n; i++) {
//             pq.offer(i + "");
//         }
//         for(int i = 0; i<k-1; i++) {
//             pq.poll();
//         }
//         return Integer.parseInt(pq.peek());
//     }
// }

class Solution {

    public int findKthNumber(int n, int k) {
        int curr = 1;
        k--;

        while (k > 0) {
            int step = countSteps(n, curr, curr + 1);
            // If the steps are less than or equal to k, we skip this prefix's subtree
            if (step <= k) {
                // Move to the next prefix and decrease k by the number of steps we skip
                curr++;
                k -= step;
            } else {
                // Move to the next level of the tree and decrement k by 1
                curr *= 10;
                k--;
            }
        }

        return curr;
    }

    // To count how many numbers exist between prefix1 and prefix2
    private int countSteps(int n, long prefix1, long prefix2) {
        int steps = 0;
        while (prefix1 <= n) {
            steps += Math.min(n + 1, prefix2) - prefix1;
            prefix1 *= 10;
            prefix2 *= 10;
        }
        return steps;
    }
}