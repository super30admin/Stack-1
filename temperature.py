"""
Iterate over temp, add it to stack, pop from stack as long as the current temp is greater than top of the stack
TC: O(n)
SP: O(n)
"""
class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        stack = []
        res = [0] * len(temperatures)
        for i, t in enumerate(temperatures):
            while stack and stack[-1][0] < t:
                popped = stack.pop()
                res[popped[1]] = i - popped[1]
            stack.append((t, i))
        return res
