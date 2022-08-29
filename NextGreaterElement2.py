class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        
        stack = []
        res = [-1 for _ in range(len(nums))]
        
        stack.append(0)
        
        for a in range(1,2*len(nums)):
            while(len(stack)!=0 and nums[a%len(nums)]>nums[stack[-1]]):
                res[stack[-1]] = nums[a%len(nums)]
                stack.pop()
            if a < len(nums):
                stack.append(a)
            
        return res