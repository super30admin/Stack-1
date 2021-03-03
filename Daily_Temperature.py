"""
Time Complexity : O(2n) 
Space Complexity : O(n) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""

class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        if not T or len(T) == 0:
            return []
        l = len(T)
        result = [0] * l
        stack = []
        
        for i in range(len(T)):
            # Inside stack we are having only index
            while stack and T[i] > T[stack[-1]]: # check value 
                idx = stack.pop()
                result[idx] = i - idx
            stack.append(i)
        return result   
