class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        #Time: O(N)
        #Space: O(N)
        if len(nums)<1:
            return None
        output = [-1]*len(nums)
        stack = []
        for i in range(len(nums)):
            while stack!= [] and nums[i]>nums[stack[-1]]:
                output[stack.pop()]=nums[i]
            stack.append(i)
        for i in range(len(nums)):
            while stack!= [] and nums[i]>nums[stack[-1]]:
                output[stack.pop()]=nums[i]
        return output
        