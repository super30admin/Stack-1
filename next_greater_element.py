"""
// Time Complexity : O(len(nums))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
Algorithm Explanation
Iterating over the nums array twice
    - For each iteration, update the stack with current index if value is less than 
    last element on the stac
    - Else pop the value and add to the result for index pointed by top
Return result
"""
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        s = []
        res = [-1] * len(nums)
        for _ in range(2):
            for i, n in enumerate(nums):
                while s and nums[s[-1]] < n:
                    res[s.pop()] = n
                s.append(i)
        return res