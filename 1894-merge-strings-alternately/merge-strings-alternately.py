class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        l1 = len(word1)
        l2 = len(word2)
        l = max(l1, l2)
        res = []
        for i in range(l):
            if i < l1:
                res.append(word1[i])
            if i < l2:
                res.append(word2[i])
        return "".join(res)
        