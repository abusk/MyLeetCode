class Solution:
    def maxVowels(self, s: str, k: int) -> int:
        i = j = 0
        mx = lm = 0
        v = ['a', 'e', 'i', 'o', 'u']
        while i<=j and j < len(s):
            if j-i+1 == k:
                if s[j] in v:
                    lm += 1
                if lm > mx:
                    mx = lm
                if s[i] in v:
                    lm-=1
                j+=1
                i+=1
            elif j-i+1 < k:
                if s[j] in v:
                    lm +=1
                j+=1
        return mx
                
            
        