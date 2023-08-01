from typing import (
    List,
)
# Time Complexity : O(n)
# Space Complexity : O(n) to maintain the stack
# Code ran on Leetcode
# Maintain a monotonically decreasing stack. If the incoming element is greater than the element at the top of the stack, pop the element from stack and update the result array since we found the first occurence of a warmer day.
class Solution:
    """
    @param temperatures: a list of daily temperatures
    @return: a list of how many days you would have to wait until a warmer temperature
    """
    def daily_temperatures(self, temperatures: List[int]) -> List[int]:
        # Write your code here
        n = len(temperatures)
        res = [0]*n

        stack = []
        for i in range(n):
            while stack != [] and temperatures[i] > temperatures[stack[-1]]:
                popped = stack.pop()
                res[popped] = i - popped
            stack.append(i)
        return res
