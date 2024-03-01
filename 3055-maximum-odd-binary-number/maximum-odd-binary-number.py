class Solution:
    def maximumOddBinaryNumber(self, s: str) -> str:
        c1 = 0
        l = len(s)
        for i in range(l):
            if s[i] == "1":
                c1+=1
        res = ["0"] * l
        res[l-1] = "1"
        r = c1-1
        j = 0
        while r > 0:
            res[j] = "1"
            j+=1
            r -=1
        return "".join(res)