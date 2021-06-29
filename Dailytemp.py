"""Daily temperatures
Time Complexity: O(N)
Space Complexity: O(N)"""

class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        result = [0]*len(temperatures)
        if len(temperatures)==0 or temperatures is None:
            return result
        stack = []
        index = 0
        for i in range(len(temperatures)):
            while stack and temperatures[i]>temperatures[stack[-1]]:
                index = stack.pop()
                result[index] = i-index
            stack.append(i)
        return result