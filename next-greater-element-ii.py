#TC = O(n)
#SC = O(n)
from typing import List
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        stack = []
        n = len(nums)
        res= [-1]*n

        for i in range(2*n):
            while stack and nums[stack[-1]] < nums[i%n]:
                j = stack.pop()
                res[j] = nums[i%n] 
            if i < n:
                stack.append(i)
        
        return res