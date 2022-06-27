class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        ans = [-1 for i in range(len(nums))]
        stack = []
        for i in range(len(nums)):
            while(len(stack)!=0 and nums[stack[-1]]<nums[i]):
                curr = stack.pop(-1)
                ans[curr] = nums[i]
            stack.append(i)
            
        for i in range(len(nums)):
            while(len(stack)!=0 and nums[stack[-1]]<nums[i]):
                curr = stack.pop(-1)
                ans[curr] = nums[i]
            if(stack[-1]==i):
                break
        return ans