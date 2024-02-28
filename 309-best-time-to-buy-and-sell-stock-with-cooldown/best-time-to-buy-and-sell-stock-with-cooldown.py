class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        sold, held, rest = float('-inf'), float('-inf'), 0

        for price in prices:
            # Alternative: the calculation is done in parallel.
            # Therefore no need to keep temporary variables
            #sold, held, reset = held + price, max(held, reset-price), max(reset, sold)

            pre_sold = sold
            sold = held + price
            held = max(held, rest - price)
            rest = max(rest, pre_sold)

        return max(sold, rest)
        