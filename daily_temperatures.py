# Time Complexity : O(N) where N is length of temperatures array
# Space Complexity : O(N) where N is length of temperatures array
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        stack = []
        result = [0 for i in range(len(temperatures))]
        for i in range(len(temperatures)):
            if len(stack) != 0 and temperatures[i] > stack[-1][0]:
                while len(stack) != 0 and temperatures[i] > stack[-1][0]:
                    result[stack[-1][1]] = i - stack[-1][1] 
                    stack.pop()
            stack.append((temperatures[i], i))
        
        return result