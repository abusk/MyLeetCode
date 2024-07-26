// class Solution {
//     public int oddEvenJumps(int[] arr) {
//         int ans = 0;
//         for(int i = 0; i<arr.length; i++) {
//             if (canReachEnd(arr, i)) {
//                 ans++;
//             }
//         }
//         return ans;
//     }

//     private boolean canReachEnd(int[] arr, int start) {
//         int n = arr.length;
//         int pos = start;
//         boolean isOddJump = true;

//         while (pos != -1) {
//             if (pos == n - 1) {
//                 return true; // Reached the end
//             }

//             if (isOddJump) {
//                 pos = minOfMax(arr, pos);
//             } else {
//                 pos = maxOfMin(arr, pos);
//             }
//             isOddJump = !isOddJump;
//         }

//         return false; // Did not reach the end
//     }

//     private int maxOfMin(int[] arr, int start) {
//         int n = arr.length;
//         int nextPos = -1;
//         int maxValue = Integer.MIN_VALUE;

//         for (int i = start + 1; i < n; i++) {
//             if (arr[i] <= arr[start] && arr[i] > maxValue) {
//                 maxValue = arr[i];
//                 nextPos = i;
//             }
//         }

//         return nextPos;
//     }
//     private int minOfMax(int[] arr, int start) {
//         int n = arr.length;
//         int nextPos = -1;
//         int minValue = Integer.MAX_VALUE;

//         for (int i = start + 1; i < n; i++) {
//             if (arr[i] >= arr[start] && arr[i] < minValue) {
//                 minValue = arr[i];
//                 nextPos = i;
//             }
//         }

//         return nextPos;
//     }
// }

class Solution {
    public int oddEvenJumps(int[] arr) {
        int n = arr.length;
        boolean[] oddJump = new boolean[n];
        boolean[] evenJump = new boolean[n];
        oddJump[n - 1] = true;
        evenJump[n - 1] = true;

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        treeMap.put(arr[n - 1], n - 1);

        for (int i = n - 2; i >= 0; i--) {
            // Odd Jump
            Integer oddNextIndex = treeMap.ceilingKey(arr[i]);
            if (oddNextIndex != null) {
                oddJump[i] = evenJump[treeMap.get(oddNextIndex)];
            }

            // Even Jump
            Integer evenNextIndex = treeMap.floorKey(arr[i]);
            if (evenNextIndex != null) {
                evenJump[i] = oddJump[treeMap.get(evenNextIndex)];
            }

            treeMap.put(arr[i], i);
        }

        int count = 0;
        for (boolean canReach : oddJump) {
            if (canReach) {
                count++;
            }
        }

        return count;
    }
}