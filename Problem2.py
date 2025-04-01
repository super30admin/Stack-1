# Problem 2 : Next Greater Element II
# Time Complexity : O(3n) where n is the size of the nums list
# Space Complexity : O(n) where n is the size of the nums list
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach
from typing import List
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        # define the stack 
        stack = []
        # define length as len(nums)
        length = len(nums)
        # define and initialize the result array with -1 with the length
        result = [-1] * length
        # loop from 1 to 2*length
        for i in range(2*length):
            # get the index as i% length
            index = i%length
            # loop till stack is not empty and value at index position is greater than the value at the index which is at top of the stack
            while stack and nums[index] > nums[stack[-1]]:
                # pop the index from the stack
                popIndex = stack.pop()
                # store the value of index position of nums to popIndex position in result
                result[popIndex] = nums[index]
            # if the i is less than length then append the index i in the stack
            if i < length:
                stack.append(i)
        # return result array 
        return result