// class Solution {
//     public int dp(String[] words, int i, Map<Character, Integer> letterMap, int[] score) {
//         if(i >= words.length) {
//             return 0;
//         }
//         int countWithWord = dp(words, i+1, letterMap, score) + count(words[i], letterMap, score);
//         int countWithoutWord = dp(words, i+1, letterMap, score);
//         return Math.max(countWithWord, countWithoutWord);
//     }
//     public int count(String word, Map<Character, Integer> localMap, int[] score) {
//         int lmx = 0;
//         for(int i = 0; i<word.length(); i++) {
//             char wCh = word.charAt(i);
//             if(localMap.getOrDefault(wCh, 0) == 0) {
//                 return 0;
//             } else {
//                 localMap.put(wCh, localMap.get(wCh)-1);
//                 lmx += score[wCh - 'a'];
//             }
//         }
//         return lmx;
//     }
    
//     public int maxScoreWords(String[] words, char[] letters, int[] score) {
//         Map<Character, Integer> letterMap = new HashMap<>();
//         for(char chr : letters) {
//             letterMap.put(chr, letterMap.getOrDefault(chr, 0) +1);
//         }
//         return dp(words, 0, letterMap, score);
//     }
// }

class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int W = words.length;
        // Count how many times each letter occurs
        freq = new int[26];
        for (char c: letters) {
            freq[c - 'a']++;
        }
        maxScore = 0;
        check(W - 1, words, score, new int[26], 0);
        return maxScore;
    }

    // Check if adding this word exceeds the frequency of any letter
    private boolean isValidWord(int[] subsetLetters) {
        for (int c = 0; c < 26; c++) {
            if (freq[c] < subsetLetters[c]) {
                return false;
            }
        }
        return true;
    }

    private int maxScore;
    private int[] freq;
    
    private void check(int w, String[] words, int[] score, int[] subsetLetters, int totalScore) {
        if (w == -1) {
            // If all words have been iterated, check the score of this subset
            maxScore = Math.max(maxScore, totalScore);
            return;
        }
        // Not adding words[w] to the current subset
        check(w - 1, words, score, subsetLetters, totalScore);
        // Adding words[w] to the current subset
        int L = words[w].length();
        for (int i = 0; i < L; i++) {
            int c = words[w].charAt(i) - 'a';
            subsetLetters[c]++;
            totalScore += score[c];
        }
        
        if (isValidWord(subsetLetters)) {
            // Consider the next word if this subset is still valid
            check(w - 1, words, score, subsetLetters, totalScore);
        }
        // Rollback effects of this word
        for (int i = 0; i < L; i++) {
            int c = words[w].charAt(i) - 'a';
            subsetLetters[c]--;
            totalScore -= score[c];
        }
    }
}