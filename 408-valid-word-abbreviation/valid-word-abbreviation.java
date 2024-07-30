// class Solution {
//     public boolean validWordAbbreviation(String word, String abbr) {
//         int wi = 0;
//         for(int i = 0; i<abbr.length(); i++) {
//             Character ch = abbr.charAt(i);
//             if(ch == '0') {
//                 return false;
//             }
//             if(Character.isDigit(ch)) {
//                 int k = i;
//                 while (Character.isDigit(ch)) {
//                     i++;
//                     ch = abbr.charAt(i);
//                 }
//                 int num = getNumber(abbr, k, i);
//                 wi = Math.min(wi+num, word.length()-1);
//                 i--;
//             } else {
//                 if(abbr.charAt(i) != word.charAt(wi)) {
//                     return false;
//                 }
//                 wi++;
//             }
//         }
//         if(wi != word.length()) {
//             return false;
//         }
//         return true;
//     }

//     public int getNumber(String abbr, int i, int j) {
//         return Integer.parseInt(abbr.substring(i, j));
//     }
// }
class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        if(abbr.length() > word.length()) return false;
        int i = 0, j = 0;
        while(i < word.length() && j < abbr.length()){
            Character wc = word.charAt(i);
            Character ac = abbr.charAt(j);
            // if both characters are different, return false
            if(Character.isLetter(ac) && wc != ac) return false;
            else{
                // encountering a digit
                if(Character.isDigit(ac)){
                    int a = ac - '0';
                    if(a == 0) return false;
                    // while we get digits, we create bigger number
                    while(j + 1 < abbr.length() && Character.isDigit(abbr.charAt(j + 1))){
                        a = a * 10 + abbr.charAt(j + 1) - '0';
                        j++;
                    }
                    // jump i end of digits position
                    i += a - 1;
                }
            }
            j++;
            i++;
        }
        return i == word.length() && j == abbr.length();
    }
}