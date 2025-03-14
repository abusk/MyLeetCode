import java.util.*;

public class Solution {
    public static int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        char[] array1 = s1.toCharArray(), array2 = s2.toCharArray();
        int count1 = 0, count2 = 0, i = 0, j = 0;
        
        while (n1 > count1) {
            if (array2[j] == array1[i]) {
                j++;
                if (array2.length == j) {
                    j = 0;
                    count2++;
                }
            }
            i++;
            if (array1.length == i) {
                i = 0;
                count1++;
            }
        }
        
        return count2 / n2;
        }

    public static void main(String[] args) {
        System.out.println(getMaxRepetitions("aaa", 3, "aa", 1));  // Output: 4
        System.out.println(getMaxRepetitions("acb", 4, "ab", 2));  // Output: 2
    }
}
