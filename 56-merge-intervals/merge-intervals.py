class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        sv = sorted(intervals, key= lambda x:x[0])
        prv = sv[0]
        res = []
        for nxt in sv:
            if prv[1] >= nxt[0]:
                prv[1] = max(prv[1], nxt[1])
            else:
                res.append(prv)
                prv = nxt
        res.append(prv)
        return res
        