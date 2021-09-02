#time:O(n)
#space:O(n)
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        new_list = nums+nums
        stack = []
        ans = [-1]*len(nums)
        for i in range(len(new_list)-1,len(nums)-1,-1):
            while(stack and new_list[i]>=stack[-1]):
                stack.pop()
            stack.append(new_list[i])
        for i in range(len(nums)-1,-1,-1):
            while(stack and nums[i]>=stack[-1]):
                stack.pop()
            if stack:
                ans[i]=stack[-1]
            stack.append(nums[i])
        return ans
            
                