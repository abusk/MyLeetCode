class Solution:
    def findSubstring(self, s: str, words: List[str]) -> List[int]:
        word_count = collections.Counter(words)
        def f_t(i):
            found = word_count.copy()
            words_used = 0
            for j in range(i, i + t, wl):
                sub = s[j : j + wl]
                if found[sub] > 0:
                    found[sub] -= 1
                    words_used += 1
                else:
                    break   
            return words_used == l
        
        l = len(words)
        if l == 0:
            return []
        wl = len(words[0])
        t = l * len(words[0])
        res = []
        for k in range(0, len(s)-t+1):
            if f_t(k):
                res.append(k)
        return res
            
        