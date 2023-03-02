"""
Time Complexity - O(n)
Space Complexity - O(n)
"""


class Solution:
    def dailyTemperatures(self, temp: List[int]) -> List[int]:
        stack = []
        out = [0 for i in range(len(temp))]
        stack.append(0)

        for i in range(1, len(temp)):
            # print(stack, i)
            while stack and temp[i] > temp[stack[-1]]:
                val = stack.pop()
                out[val] = i - val
            stack.append(i)
        return out
