"""
Approach: Stack
Since the list is circular, you'd have to iterate through it twice in order to get the next greater element of all the elements

1. use a stack to resolve all elements
2. since you'd circularly iterate through the list, make sure that you do not reprocess same elements

TC: O(4n)
SC: O(n)
"""
from collections import deque
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        n = len(nums)
        result = [-1]*n # O(n)
        stack = deque()
        stack.append(0)
        for i in range(1, 2*n): #O(3n)
            i = i % n # to avoid out of bound error
            while stack and nums[i] > nums[stack[-1]]:
                top = stack.pop()
                result[top] = nums[i]
            if result[i] == -1: stack.append(i) # so that same elements are not processed twice
        return result