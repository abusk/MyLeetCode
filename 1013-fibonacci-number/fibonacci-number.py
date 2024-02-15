class Solution:
    def fib(self, n: int) -> int:
        @cache
        def fn(n):
            if n <=1:
                return n
            return fn(n-1) + fn(n-2)
        return fn(n)
        