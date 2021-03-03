# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :


# Your code here along with comments explaining your approach

class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        if not nums:
            return []
        n = len(nums)
        res = [-1 for i in range(len(nums))]
        
        stack = []
        
        for i in range(2*len(nums)):
            while stack and nums[i%len(nums)] > nums[stack[-1]]:
                idx = stack.pop()
                res[idx] = nums[i%len(nums)]
            
            if i < len(nums):
                stack.append(i)
                
        return res