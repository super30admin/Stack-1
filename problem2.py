# Time-Complexity: O(n)
# Space Complexity: O(n)
# Leetcode status: Accepted
class Solution(object):
    def nextGreaterElements(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        n = len(nums)
        result = [-1] * n
        stk = []
        for i in range(2*n):
            while len(stk) != 0 and nums[i%n]  > nums[stk[-1]]:
                result[stk[-1]] = nums[i%n]
                stk.pop()
            stk.append(i%n)
        return result
