class Solution:
    def maximumOddBinaryNumber(self, s: str) -> str:
        l = len(s)
        ones_cnt = s.count('1')
        return '1' * (ones_cnt - 1) + '0' * (l - ones_cnt) + '1'