# Time Complexity : O(n), where n is the length of the nums array
# Space Complexity : O(n)
from typing import List


class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        n = len(nums)
        stack = []
        result = [-1] * n

        for i in range(2 * n):
            while stack and nums[i % n] > nums[stack[-1]]:
                index = stack.pop()
                result[index] = nums[i % n]
            stack.append(i % n)

        return result