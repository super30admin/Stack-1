#Time Complexity : O(3n)
#Space Complexity :O(n)
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this : No

from ast import List

class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        n = len(nums)
        result = [-1] * n
        stack = []

        for i in range(2*n):
            while stack and nums[stack[-1]] < nums[i%n]:
                popped = stack.pop()
                result[popped] = nums[i%n]
            
            if i < n:
                stack.append(i)
        
        return result

   
