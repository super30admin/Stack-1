"""
https://leetcode.com/problems/daily-temperatures/
"""


class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        """
        TC:O(n)
        sc:(n)
        """
        stack = []
        result = [0] * len(temperatures)
        stack.append(0)
        for i in range(1, len(temperatures)):
            ###if the next temp is resolving tempratures inside the stack
            ###(culd be 0 , on or more, keep doing this operation
            ###untill you resolve all lesser tempratures)
            while len(stack) > 0 and temperatures[i] > temperatures[stack[-1]]:
                top = stack.pop()
                result[top] = i - top
            stack.append(i)
        return result
