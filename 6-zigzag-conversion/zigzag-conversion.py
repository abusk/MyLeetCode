class Solution:
    def convert(self, s: str, numRows: int) -> str:
        if numRows == 1:
            return s
        l = len(s)
        mt = [[" "] * l for _ in range(numRows)]
        i, j = 0, 0
        zz = True
        for ci in range(l):
            if zz:
                mt[i][j] = s[ci]
                i += 1
                if i == numRows:
                    zz = False
                    j += 1
                    i -= 2
            else:
                mt[i][j] = s[ci]
                i -=1
                j +=1
                if i == -1:
                    zz = True
                    j -=1
                    i += 2
        ans = ""
        for row in mt:
            ans += "".join(row)
        return ans.replace(" ", "")
            
        