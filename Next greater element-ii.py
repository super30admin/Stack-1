 # Time Complexity : O(n)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :No
#
#
# // Your code here along with comments explaining your approach

 class Solution:
     def nextGreaterElements(self, nums: List[int]) -> List[int]:
         n = len(nums)
         arr = [-1] * n
         stack = []
         for i in range(2 * n):
             while stack and nums[stack[-1]] < nums[i % n]:
                 curr = stack.pop()
                 arr[curr] = nums[i % n]

             if (i < n):
                 stack.append(i)
         return arr