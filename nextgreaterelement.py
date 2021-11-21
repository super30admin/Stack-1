"""
https://leetcode.com/problems/next-greater-element-ii/

"""


class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        # Tc: O(3n)
        # sc: O(n)
        result = [-1] * len(nums)
        if nums == None:
            return result
        stack = []
        for i in range(2 * len(nums)):

            while stack and nums[i % len(nums)] > nums[stack[-1]]:
                top = stack.pop()
                result[top] = nums[i % len(nums)]
            if i < len(nums):
                stack.append(i)
        return result


