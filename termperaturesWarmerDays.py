# https://leetcode.com/problems/daily-temperatures/
# Approach: Monotonic decreasing Stack
# Algorithm:
# 1. Create a stack and start adding temperatures to the stack until you find a temperature that is bigger than stack top
# 2. When you find such temperature, then keep comparing it with stack top and if it is bigger than top, then pop the top
# 3. Update the result to difference in indices and then push current index to stack
# TC: O(2n)
# SC: O(n)
class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        if len(temperatures) == 1:
            return [0]
        
        stack = []
        res = [0] * len(temperatures)
        
        for i in range(len(temperatures)):
            while stack and temperatures[stack[-1]] < temperatures[i]:
                idx = stack.pop()
                res[idx] = i - idx
            stack.append(i)
        return res