class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        
        length = len(nums)
        ans = [-1]*len(nums)
        stack = []
        nums = nums+nums
        for index, value in enumerate(nums):
            while stack and nums[stack[-1]]<value:
                ans[stack.pop()] = value
            if index<len(nums):
                stack.append(index)
        return ans
##Temperature logic, go over it once more, don't append second time 
TIme: O(n)
Space: O(n)
