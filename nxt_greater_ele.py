# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach

from typing import List


class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        """
        stack, push smaller, pop if bigger found
        circular -> loop twice

        """

        stack = []  # initializing empty stack
        n = len(nums)
        ans = [-1] * n  # initializing the result empty array to -1

        for i, num in enumerate(nums):

            while stack and num > nums[stack[-1]]:
                ans[stack.pop()] = num
            stack.append(i)

        for i in range(stack[-1]):
            while stack and nums[i] > nums[stack[-1]]:
                ans[stack.pop()] = nums[i]

        return ans
