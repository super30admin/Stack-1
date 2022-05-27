#Time Complexity : O(N)
#Space Complexity : O(N)
#Did this code successfully run on Leetcode : YES
#Any problem you faced while coding this : NO
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        stack = []
        li = [-1] * len(nums)
        for i in range(len(nums)):
            while stack and nums[stack[-1]] < nums[i]:
                popped = stack.pop()
                li[popped] = nums[i]
            stack.append(i)
            
        for i in range(len(nums)):
            while stack and nums[stack[-1]] < nums[i]:
                    popped = stack.pop()
                    li[popped] = nums[i]
            
        return li