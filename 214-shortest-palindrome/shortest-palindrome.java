// class Solution {
//     public String shortestPalindrome(String s) {
//         if(s.length() <=1) {
//             return s;
//         }
//         List<Character> left = new ArrayList<>();
//         List<Character> right = new ArrayList<>();
//         char mid = ' ';
//         int i = 0;
//         int j = s.length() -1;
//         while (i <= j) {
//             char lchar = s.charAt(i);
//             char rchar = s.charAt(j);
//             if(i == j) {
//                 mid = s.charAt(i);
//                 i++;
//                 j--;
//             } else if(lchar == rchar) {
//                 left.add(rchar);
//                 right.add(rchar);
//                 i++;
//                 j--;
//             } else {
//                 left.add(rchar);
//                 right.add(rchar);
//                 j--;
//             }
//         }
//         String ans = "";
//         for(char ch : left) {
//             ans += ch;
//         }
//         if(mid != ' ') {
//             ans += mid;
//         }
//         for(int k = right.size()-1; k>=0; k--) {
//             ans += right.get(k);
//         }
//         return ans;
//     }
// }

// class Solution {

//     public String shortestPalindrome(String s) {
//         int length = s.length();
//         String reversedString = new StringBuilder(s).reverse().toString();

//         // Iterate through the string to find the longest palindromic prefix
//         for (int i = 0; i < length; i++) {
//             if (
//                 s.substring(0, length - i).equals(reversedString.substring(i))
//             ) {
//                 return new StringBuilder(reversedString.substring(0, i))
//                     .append(s)
//                     .toString();
//             }
//         }
//         return "";
//     }
// }

class Solution {

    public String shortestPalindrome(String s) {
        String reversedString = new StringBuilder(s).reverse().toString();
        String combinedString = s + "#" + reversedString;
        int[] prefixTable = buildPrefixTable(combinedString);

        int palindromeLength = prefixTable[combinedString.length() - 1];
        StringBuilder suffix = new StringBuilder(
            s.substring(palindromeLength)
        ).reverse();
        return suffix.append(s).toString();
    }

    private int[] buildPrefixTable(String s) {
        int[] prefixTable = new int[s.length()];
        int length = 0;
        for (int i = 1; i < s.length(); i++) {
            while (length > 0 && s.charAt(i) != s.charAt(length)) {
                length = prefixTable[length - 1];
            }
            if (s.charAt(i) == s.charAt(length)) {
                length++;
            }
            prefixTable[i] = length;
        }
        return prefixTable;
    }
}