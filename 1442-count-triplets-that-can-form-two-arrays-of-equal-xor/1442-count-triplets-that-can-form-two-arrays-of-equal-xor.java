// class Solution {
//     public int countTriplets(int[] arr) {
//         int c = 0;
//         int l = arr.length;
//         for(int k = 0; k<l; k++) {    
//             int a = 0;
//             for(int i = k; i<l; i++) {
//                 a ^= arr[i];
//                 int b = 0;
//                 for(int j = i+1; j<l; j++) {
//                     b^=arr[j];
//                     if(a == b) {
//                         c++;
//                     }
//                 }
//             }
//         }
//         return c;
//     }
// }
class Solution {

    public int countTriplets(int[] arr) {
        int size = arr.length;
        int count = 0;
        int prefix = 0;

        // Maps to store counts and totals of XOR values encountered
        Map<Integer, Integer> countMap = new HashMap<>();
        countMap.put(0, 1);
        Map<Integer, Integer> totalMap = new HashMap<>();

        // Iterating through the array
        for (int i = 0; i < size; ++i) {
            // Calculating XOR prefix
            prefix ^= arr[i];

            // Calculating contribution of current element to the result
            count +=
            countMap.getOrDefault(prefix, 0) * i -
            totalMap.getOrDefault(prefix, 0);

            // Updating total count of current XOR value
            totalMap.put(prefix, totalMap.getOrDefault(prefix, 0) + i + 1);
            countMap.put(prefix, countMap.getOrDefault(prefix, 0) + 1);
        }

        return count;
    }
}