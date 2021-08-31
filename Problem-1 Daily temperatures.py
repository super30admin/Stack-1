class Solution:
    def dailyTemperatures(self, temperatures):
        n = len(temperatures)
        result = [0 for i in range(n)]
        stack = []

        for i in range(n):
            while stack and temperatures[i] > temperatures[stack[-1]]:
                index = stack.pop()
                result[index] = i - index
            stack.append(i)
        return result
