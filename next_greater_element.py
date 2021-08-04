# Time Complexity: O(n)
# Space Complexity: O(n)
class Solution:
    def nextGreaterElements(self, nums):

        stack = []
        result = [-1 for i in range(len(nums))]

        n = len(nums)

        for i in range(n):
            while stack and nums[stack[-1]] < nums[i]:
                result[stack.pop()] = nums[i]
            stack.append(i)

        for i in range(n):
            while stack and nums[stack[-1]] < nums[i]:
                result[stack.pop()] = nums[i]

        return result