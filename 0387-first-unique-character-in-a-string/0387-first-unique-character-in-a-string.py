class Solution:
    def firstUniqChar(self, s: str) -> int:
        lst = [0] * 26
        for i in range(0, len(s)):
            lst[ord(s[i]) - ord('a')] += 1
        for i in range(0, len(s)):
            if lst[ord(s[i]) - ord('a')] == 1:
                return i
        return -1
            
        