# Time Complexity : O(n), Where n is number of elements in temperatures
# Space Complexity : O(n), Where n is number of elements in temperatures
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Nothing specific

from typing import List
from collections import deque
class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        #Edge Case
        if(len(temperatures)==0):
            return []
        
        stack=deque()
        n=len(temperatures)
        output=[0 for i in range(n)] 
        for i in range(n):
            while(len(stack)!=0 and temperatures[stack[-1]]<temperatures[i]):
                output[stack[-1]]=i-stack[-1]
                stack.pop()
            stack.append(i)
        return output
            