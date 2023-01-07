import numpy as np
class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        n = len(temperatures)

        res = np.zeros(n, dtype = np.int)
        stack = []

        for i in range(0, n-1):
            if temperatures[i+1] > temperatures[i]:
                res[i] = 1
                while stack and stack[-1][1] < temperatures[i+1]:
                    index, p = stack.pop()
                    res[index] = i+1 - index
            else:
                stack.append((i, temperatures[i]))
        return res
