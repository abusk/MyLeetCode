// class Solution {
//     int count = 0;
//     public int countGoodSubsequences(String s) {
//         allSeq(s.toCharArray(), 0, "");
//         return count;
//     }
//     private void allSeq(char[] chars, int i, String res) {
//         if(i == chars.length) {
//             if(equalCount(res)) {
//                 count++;
//             }
//             return;
//         }
//         allSeq(chars, i+1, res+chars[i]);
//         allSeq(chars, i+1, res);
//     }
//     private boolean equalCount(String str) {
//         if(str.length() == 0) {
//             return false;
//         }
//         int[] letter = new int[26];
//         for(int i =0; i< str.length(); i++) {
//             letter[str.charAt(i) - 'a']++;
//         }
//         int c = letter[str.charAt(0) - 'a'];
//         for(int i =0; i< str.length(); i++) {
//             if(c != letter[str.charAt(i) - 'a']) {
//                 return false;
//             }
//         }
//         return true;
//     }
// }

class Solution {
    private long mod = (long) (1e9 + 7);
    private Long[] fact;

    public int countGoodSubsequences(String s) {
        int n = s.length();
        fact = new Long[n + 1];
        int[] freq = new int[26];
        int maxf = 0;
        for (int i = 0; i < n; ++i) {
            ++freq[s.charAt(i) - 'a'];
        }
        for (int i = 0; i < 26; ++i) {
            maxf = Math.max(maxf, freq[i]);
        }
        // for each given freq k, for each char that has freq = n, we have 1 + C(n, k) ways.
        // 1 is because the char may not be chosen at all
        // so the result for a given k is (1+c(n1,k))*(1+c(n2,k))*...(1+c(nn, k)) -1. -1 is to exclude all empty choices
        long res = 0;
        for (int k = 1; k <= maxf; ++k) {
            long cur = 1;
            for (int i = 0; i < 26; ++i) {
                if (freq[i] > 0) {
                    cur *= (1 + combi(freq[i], k));
                    cur %= mod;
                }
            }
            res += cur - 1;
            res %= mod;
        }
        return (int) res;
    }

    private long fact(int n) {
        if (fact[n] != null) {
            return fact[n];
        }
        long res = 0;
        if (n == 0) {
            res = 1L;
        } else {
            res = fact(n - 1) * n;
            res %= mod;
        }
        fact[n] = res;
        return res;
    }

    // n! /( k!*(n-k)!) 
	// a/b mod n = a mod n * modinverse(b) mod n
    private long combi(int n, int k) {
        if (n < k) {
            return 0;
        }
        if (n == k) {
            return 1;
        }
        long res = fact(n);
        res *= modinverse(fact(k), mod);
        res %= mod;
        res *= modinverse(fact(n - k), mod);
        res %= mod;
        return res;
    }


    private long modinverse(long a, long m) {
        long m0 = m;
        long y = 0, x = 1;
        if (m == 1) {
            return 0;
        }
        while (a > 1) {
            long q = a / m;
            long t = m;
            m = a % m;
            a = t;
            t = y;
            y = x - q * y;
            x = t;
        }
        if (x < 0) {
            x += m0;
        }
        return x;
    }
}