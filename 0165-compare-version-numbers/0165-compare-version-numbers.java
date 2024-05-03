// class Solution {
//     public int compareVersion(String version1, String version2) {
//         String v1 = this.getMv(version1);
//         String v2 = this.getMv(version2);
//         int l1 = v1.length();
//         int l2 = v2.length();
        
//         for(int i = 0; i < Math.min(l1, l2); i++) {
//             int a = Integer.parseInt("" + v1.charAt(i));
//             int b = Integer.parseInt("" + v2.charAt(i));
//             if(a < b) {
//                 return -1;
//             }
//             if(a > b) {
//                 return 1;
//             }
//         }
//         if(l1 == l2) {
//             return 0;
//         } 
//         if(l1 < l2) {
//             return -1;
//         } 
//         return 1;
//     }
//     private String getMv(String version) {
//         StringBuilder v1 = new StringBuilder();
//         boolean dot = true;
//         for(int i = 0; i<version.length(); i++) {
//             if(version.charAt(i) == '.') {
//                 dot = true;
//                 continue;
//             }
//             else if(version.charAt(i) == '0' && dot) {
//                 continue;
//             } else if(version.charAt(i) == '0' && !dot) {
//                 v1.append(version.charAt(i));
//             } 
//             else if(version.charAt(i) != '0') {
//                 v1.append(version.charAt(i));
//                 dot = false;
//             }
//         }
//         return v1.toString();
//     }
// }
class Solution {
    public int compareVersion(String version1, String version2) {
        String[] nums1 = version1.split("\\.");
        String[] nums2 = version2.split("\\.");
        int n1 = nums1.length, n2 = nums2.length;

        // compare versions
        int i1, i2;
        for (int i = 0; i < Math.max(n1, n2); ++i) {
            i1 = i < n1 ? Integer.parseInt(nums1[i]) : 0;
            i2 = i < n2 ? Integer.parseInt(nums2[i]) : 0;
            if (i1 != i2) {
                return i1 > i2 ? 1 : -1;
            }
        }
        //The versions are equal
        return 0;
    }
}