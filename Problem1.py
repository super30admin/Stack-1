# Time Complexity : O(n)
# Space Complexity:o(n)
#  Did this code successfully run on Leetcode : Yes

class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        if temperatures is None or len(temperatures) == 0:
            return temperatures

        stack = []
        result = [0] * len(temperatures)

        for i in range(0, len(temperatures)):
            while len(stack) != 0 and temperatures[stack[-1]] < temperatures[i]:
                result[stack[-1]] = i - stack[-1]
                stack.pop()

            stack.append(i)

        return result