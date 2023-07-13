#Time Complexity:O(n)
#Space Complexity:O(n)

class Solution(object):
    def nextGreaterElements(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        if len(nums)==0:
            return []
        stack=[]
        result=[-1 for i in range(len(nums))]
        for k in range(2):
            for i in range(len(nums)):
                while stack and nums[stack[-1]]<nums[i]:
                    result[stack.pop()]=nums[i]
                stack.append(i)
        return result
            