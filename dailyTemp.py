class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        # T: O(n), S: O(n)
        n = len(temperatures)
        res = [0] * n
        stack = []  # Stores indices

        for i, temp in enumerate(temperatures):
            while stack and temperatures[stack[-1]] < temp:
                prevIdx = stack.pop()
                res[prevIdx] = i - prevIdx
            stack.append(i)

        return res
