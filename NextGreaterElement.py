# Tc - O(n)
# SC - O(n)
class Solution(object):
    def nextGreaterElements(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        size = len(nums)

        stack = []

        if size == 0:
            return []

        result = [-1] * size

        for i in range(2*size + 1):
            while stack and nums[stack[-1]] < nums[i % size] and i % size is not stack[-1]:
                result[stack[-1]] = nums[i % size]
                stack.pop()

            stack.append(i % size)

        return result
