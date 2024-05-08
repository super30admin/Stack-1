# Time Complexity : O(3n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        n = len(nums)
        res = [-1]*len(nums)
        stack = []
        for i in range(2*n):
            while stack and nums[i%n]>nums[stack[-1]]: 
                    stack_idx = stack.pop()
                    res[stack_idx] = nums[i%n]
            if i < n:  #Push the index to stack only for first traversal 
                stack.append(i)
        return res
