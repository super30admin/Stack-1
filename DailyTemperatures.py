"""
Given an array of integers temperatures represents the daily temperatures, 
return an array answer such that answer[i] is the number of days you have to wait after 
the ith day to get a warmer temperature. If there is no future day for which this is possible, 
keep answer[i] == 0 instead.

"""

# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on leetcode : Yes
# Any problem you faced while coding this : No

from typing import List

class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        
        if temperatures == None or len(temperatures) == 0:
            return temperatures
        
        stack = []
        n = len(temperatures)
        res = [0] * n
        
        for i in range(n):
            while len(stack) != 0 and temperatures[i] > temperatures[stack[-1]]:
                popped = stack.pop()
                res[popped] = i - popped
                
            stack.append(i)
            
        return res