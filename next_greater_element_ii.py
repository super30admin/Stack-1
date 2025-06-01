class Solution(object):
    def nextGreaterElements(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """

        result = [-1]*len(nums)

        stack = []

        for i in range(len(nums)*2):
            while stack and nums[i%len(nums)]>nums[stack[-1]]:
                index=stack.pop()
                result[index] = nums[i%len(nums)]
            if i<len(nums):
                stack.append(i)

        return result