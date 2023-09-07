# Time Complexity: O(n)
# Space Complexity: O(n)
# Did this problem run on Leetcode: Yes
# Any issues faced doing this problem: No

class Solution(object):
    def nextGreaterElements(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        stack = []
        res = ([-1] * len(nums))
        for _ in range(2):
            for i in range(len(nums)):
                while stack and nums[stack[-1]] < nums[i]:
                    res[stack.pop()] = nums[i]
                stack.append(i)
        return res