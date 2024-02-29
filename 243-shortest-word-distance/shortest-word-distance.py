class Solution:
    def shortestDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        sm = len(wordsDict)
        m = n = -1
        for i, s in enumerate(wordsDict):
            if s == word1:
                m = i
            if s == word2:
                n = i
            if m != -1 and n != -1:
                sm = min(sm, abs(m -n))
        return sm
        