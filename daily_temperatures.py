# Time Complexity: O(n)
# Space Complexity: O(n)
# ran on Leetcode: Yes

class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        if not len(temperatures):
            return []
        stack = []
        n = len(temperatures)
        out = [0] * n
        
        i = 0
        for i in range(n):
            while len(stack) and temperatures[i] > temperatures[stack[-1]]:
                elem = stack.pop()
                out[elem] = i - elem
            stack.append(i)
                
        return out