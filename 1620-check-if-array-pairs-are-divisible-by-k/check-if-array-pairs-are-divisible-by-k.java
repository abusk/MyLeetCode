// class Solution {
//     public boolean canArrange(int[] arr, int k) {
//         Map<Integer, Integer> map = new HashMap<>();
//         for(int i = 0; i<arr.length; i++) {
//             int num = ((arr[i] %k) + k) % k;
//             map.put(num, map.getOrDefault(num, 0) +1);
//         }
//         for(int i = 0; i<arr.length; i++) {
//             int num = ((arr[i] %k) + k) % k;
//             if(num == 0) {
//                 if(map.get(num) % 2 == 1) {
//                     return false;
//                 }
//             } else if(map.get(num) != map.getOrDefault(k - num, 0)) {
//                 return false;
//             }
//         }
//         return true;
//     }
// }

class Solution {

    public boolean canArrange(int[] arr, int k) {
        Map<Integer, Integer> remainderCount = new HashMap<>();

        // Store the count of remainders in a map.
        for (int i : arr) {
            int rem = ((i % k) + k) % k;
            remainderCount.put(rem, remainderCount.getOrDefault(rem, 0) + 1);
        }

        for (int i : arr) {
            int rem = ((i % k) + k) % k;

            // If the remainder for an element is 0, then the count
            // of numbers that give this remainder must be even.
            if (rem == 0) {
                if (remainderCount.get(rem) % 2 == 1) return false;
            }
            // If the remainder rem and k-rem do not have the
            // same count then pairs cannot be made.
            else if (
                !Objects.equals(
                    remainderCount.get(rem),
                    remainderCount.get(k - rem)
                )
            ) return false;
        }
        return true;
    }
}