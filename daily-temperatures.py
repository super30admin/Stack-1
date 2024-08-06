#TC = O(n)
#SC = O(n)
from typing import List
class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        stack = []
        n = len(temperatures)
        stack.append(0)
        result = [0]*n
        for i in range(1, n):
            while stack and temperatures[stack[-1]] < temperatures[i]:
                j = stack.pop()
                result[j] = i - j
            stack.append(i)
        
        return result


        