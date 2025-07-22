# // Time Complexity : o(n) 
# // Space Complexity : o(n)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no

# // Your code here along with comments explaining your approach
# We use a stack to keep track of indices where we haven’t found a warmer day yet.
# For each temperature, if it’s warmer than the one at the top of the stack, we found our answer for that earlier day.
# We keep doing this until we handle all temperatures one by one.

from typing import List
class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        res = [0]*len(temperatures)
        stack = []
        n = len(temperatures)
        for i in range(n):
            while stack and temperatures[i]>temperatures[stack[-1]]:
                popped = stack.pop()
                res[popped] = i-popped
            stack.append(i)
        return res

        