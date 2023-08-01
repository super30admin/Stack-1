from typing import (
    List,
)

# Time Complexity : O(n)
# Space Complexity : O(n) to maintain the stack
# Code ran on Leetcode
# Maintain a monotonically decreasing stack. Iterate over the array two times. 
# If the incoming element is greater than the element at the top of the stack, pop the element from stack and update the result array. Append elements to the stack only in the first iteration

class Solution:
    """
    @param nums: an array
    @return: the Next Greater Number for every element
    """
    def next_greater_elements(self, nums: List[int]) -> List[int]:
        # Write your code here
        n = len(nums)
        stack = []; res = [-1]*n
        for i in range(2*n):
            while stack != [] and nums[i%n] > nums[stack[-1]]:
                popped = stack.pop()
                res[popped] = nums[i%n]
            if i < n:
                stack.append(i)
        return res
