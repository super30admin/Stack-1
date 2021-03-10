# -*- coding: utf-8 -*-
"""
TC:O(N) where N is the number of elements
SC:O(N) deque used
"""

from collections import deque

class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        n = len(nums)
        result = [-1] * n
        stack = deque()
        
        for i in range(2*n-1,-1,-1):
            while stack and stack[-1] <= nums[i % n]:
                stack.pop()
            result[i % n] = stack[-1] if stack else -1
            stack.append(nums[i % n])
            
        return result