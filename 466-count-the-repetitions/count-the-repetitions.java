import java.util.*;

class Solution {
    public static int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int s1Len = s1.length(), s2Len = s2.length();
        Map<Integer, int[]> seen = new HashMap<>(); // Stores cycles
        
        int s1Count = 0, s2Count = 0, index = 0; // Tracking cycles
        while (s1Count < n1) {
            for (char c : s1.toCharArray()) {
                if (c == s2.charAt(index)) {
                    index++;
                    if (index == s2Len) { // Found one full s2 in the cycle
                        index = 0;
                        s2Count++;
                    }
                }
            }
            s1Count++;

            // Check for cycle
            if (seen.containsKey(index)) {
                int[] prev = seen.get(index);
                int prevS1Count = prev[0], prevS2Count = prev[1];

                int cycleLen = s1Count - prevS1Count;
                int cycleS2Count = s2Count - prevS2Count;
                int remainingCycles = (n1 - s1Count) / cycleLen;

                s1Count += remainingCycles * cycleLen;
                s2Count += remainingCycles * cycleS2Count;
            } else {
                seen.put(index, new int[]{s1Count, s2Count});
            }
        }

        return s2Count / n2;
    }

    public static void main(String[] args) {
        System.out.println(getMaxRepetitions("aaa", 3, "aa", 1));  // Output: 4
        System.out.println(getMaxRepetitions("acb", 4, "ab", 2));  // Output: 2
    }
}
