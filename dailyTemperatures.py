# Time Complexity: O(2n)
# Space Complexity: O(n)
class Solution:
    def dailyTemperatures(self, temperatures):
        n = len(temperatures)
        stack = []
        res = [0] * n
        for i in range(n):
            while stack and temperatures[i] > stack[-1][0]:
                temp, idx = stack.pop()
                res[idx] = i - idx
            stack.append([temperatures[i], i])
        return res