# Problem 1 : Daily Temperatures
# Time Complexity : O(2n) where n is the size of the temperature
# Space Complexity : O(n) where n is the size of the temperature
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach
from typing import List
class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        # define stack which will be monotonic decreasing stack
        stack = []
        # define and initialze the result list with temperature length with 0
        result = [0] * len(temperatures)
        # loop through temperature list
        for i in range(len(temperatures)):
            # get the value of the ith element and store in current
            current = temperatures[i]
            # lop till stack is not empty and the current is greater than element at the index which is at top of the stack 
            while stack and current > temperatures[stack[-1]]:
                # pop th index from the stack
                popIndex = stack.pop()
                # store the value (i-popIndex) at the popIndex of the result
                result[popIndex] = i - popIndex
            # append the index i to the stack
            stack.append(i)
        # return result array
        return result