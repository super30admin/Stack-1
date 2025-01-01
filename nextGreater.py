"""
Do two pass to identify next greater elem.
TC: O(n)
SP: O(n)
"""
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        stack = []
        res = [-1] * len(nums)
        for i in range(2 * len(nums)):
            j = i % len(nums)
            while stack and nums[stack[-1]] < nums[j]:
                popped = stack.pop()
                res[popped] = nums[j]
            if j < len(nums):
                stack.append(j)
            elif j == stack[-1]:
                break
        return res
