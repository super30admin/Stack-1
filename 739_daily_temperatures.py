# Leetcode: https://leetcode.com/problems/daily-temperatures/

"""
Approach: Using Stack
Time Complexity: O(N), where N is the length of an array T
Space Complexity: O(W), where W is the number of allowed values for T[i]. Each index gets pushed and popped at most once from the stack.
"""


class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        output = [0] * len(T)
        stack = []

        for idx in range(len(T)):
            while stack and T[idx] > T[stack[-1]]:
                index = stack.pop()
                output[index] = idx - index
            stack.append(idx)

        while stack:
            output[stack.pop()] = 0

        return output