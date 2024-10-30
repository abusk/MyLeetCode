// class Solution {
//     public void merge(int[] nums1, int m, int[] nums2, int n) {
//         int lastIndex = m + n - 1;
//         int nums2Index = n -1;
//         int nums1Index = m -1;
//         while (nums2Index >= 0) {
//             if (nums1Index >= 0 && nums2[nums2Index] < nums1[nums1Index]) {
//               nums1[lastIndex--] = nums1[nums1Index--];
//             } else {
//                 nums1[lastIndex--] = nums2[nums2Index--];
//             }
//         }
//     }
// }
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int lastIndex = m + n - 1;
        int nums2Index = n -1;
        int nums1Index = m -1;
        while (nums2Index >= 0) {
            if (nums1Index >= 0 && nums2[nums2Index] < nums1[nums1Index]) {
              nums1[lastIndex--] = nums1[nums1Index--];
            } else {
                nums1[lastIndex--] = nums2[nums2Index--];
            }
        }
    }
}