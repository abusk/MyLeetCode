class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        lh = len(haystack)
        ln = len(needle)
        if haystack == needle:
            return 0
        if lh == ln and haystack != needle:
            return -1
        if ln > lh:
            return -1
        start = 0
        while start < lh:
            i = start
            j = 0
            while j < ln and i < lh:
                n = needle[j]
                h = haystack[i]
                if h == n:
                    i += 1
                    j +=1
                else:
                    i += 1
                    break
            if j == ln:
                return start
            start += 1
        return -1
            
                
                
                
        