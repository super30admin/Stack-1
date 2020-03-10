"""
Time Complexity : O(n) 
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this: none
"""

class Solution:
    def nextGreaterElements(self, nums):
        if not nums or len(nums) == 0:
            return []
        
        n = len(nums)
        result = [-1] * n
        stack = []
        
        
        for i in range(2*n):
            temp = i % n
            while stack and nums[stack[-1]] < nums[temp]:
                idx = stack.pop()
                result[idx] = nums[temp]
            stack.append(temp)
            
        return result

s = Solution()
print(s.nextGreaterElements([1,2,1]))