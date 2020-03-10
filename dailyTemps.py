"""
Time Complexity : O(n) 
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this: none
"""

class Solution:
    def dailyTemperatures(self, T):
        if not T or len(T) == 0:
            return []
        
        n = len(T)
        result = [0] * n
        stack = []
        
        for i in range(n):
            while stack and T[stack[-1]] < T[i]:
                idx = stack.pop()
                result[idx] = i - idx
            stack.append(i)
            
        return result
    
s = Solution()
print(s.dailyTemperatures([73,74,75,71,69,72,76,73]))