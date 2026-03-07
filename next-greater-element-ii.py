''' Time Complexity : O(n) 
    Space Complexity : O(n) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No

'''

class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        stack = []
        n = len(nums)
        result = [-1] * n
        for i in range(n):
            while stack and nums[i] > nums[stack[-1]]:
                poped = stack.pop()
                result[poped] = nums[i]
            stack.append(i)
        
        for i in range(n):
            while stack and nums[i] > nums[stack[-1]]:
                poped = stack.pop()
                result[poped] = nums[i]
        
        return result


