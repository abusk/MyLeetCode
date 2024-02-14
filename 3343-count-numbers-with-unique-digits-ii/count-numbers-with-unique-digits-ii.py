class Solution:
    def numberCount(self, a: int, b: int) -> int:
        def uniq(num):
            count = collections.Counter(str(num))
            for v in count.values():
                if v > 1:
                    return False
            return True
        c = 0
        for n in range(a, b+1):
            if uniq(n):
                c+= 1
        return c
        