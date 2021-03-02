
#Time Complexity: O(N)
#Space Complexity: O(N)
#Run on Leetcode: Yes
#Any Issues: No

class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        stack=[]
        ans=[-1]*len(nums)
        for i in range(len(nums)):
            while stack and nums[i]>nums[stack[-1]]:
                idx=stack.pop()
                ans[idx]=nums[i]
            stack.append(i)
        for i in range(len(nums)):
            while stack and nums[i]>nums[stack[-1]]:
                idx=stack.pop()
                ans[idx]=nums[i]
        stack.append(i)
        return ans
        