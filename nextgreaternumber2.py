# Time Complexity : O(N) where N length of nums
# Space Complexity : O(N) where N is size of stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach:
# I am using a stack to keep track of the indices of the elements for which we are trying to find the next greater element.
# I will iterate through the array twice (to simulate circular behavior) and for each element,
# I will check if it is greater than the element at the index stored at the top of the stack.
# If it is, I will pop the index from the stack and update the result for that index.
# I will continue this process until the stack is empty or the current element is not greater than the element at the index stored at the top of the stack.
# If we are in the first pass through the array, I will push the current index onto the stack.
# Finally, I will return the result array.

from typing import List
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        n = len(nums)
        stack = []
        result = [-1] * n
        for i in range(0,2*n):
            while stack and nums[stack[-1]] < nums[i%n]:
                result[stack.pop()] = nums[i%n]
            if  stack and i %n == stack[-1]:
                break
            if i < n:
                stack.append(i)
        return result
 
        