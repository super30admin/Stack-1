"""
Time Complexity : O(n) where n is the length of the nums array
Space Complexity : O(n) where n is the length of the nums array
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        if len(nums) == 0:
            return []
        n = len(nums)
        result = [-1]*n
        stack = []
        # We traverse through the nums twice so the range would be 2n because it is a
        # circular array. We push all the indexes of the elements in the stack until
        # we find a greater element. When we find it we pop it and update the result
        # array with the updated value
        for i in range(2*n):
            while stack and nums[i % n] > nums[stack[-1]]:
                index = stack.pop()
                result[index] = nums[i % n]
            if i < n:
                stack.append(i)
        return result