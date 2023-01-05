# Time Complexity : O(n), Where n is number of elements in nums
# Space Complexity : O(n), Where n is number of elements in nums
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Nothing specific

from typing import List
from collections import deque

class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        n=len(nums)
        stack=deque()
        output=[-1 for i in range(n)]
        for i in range(2*n):
            while(len(stack)!=0 and nums[i%n]>nums[stack[-1]]):
                output[stack[-1]]=nums[i%n]
                stack.pop()
            if(i<n):
                stack.append(i)
        return output
            