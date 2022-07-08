# Time Complexity : O(N) where N is length of nums array
# Space Complexity : O(N) where N is length of nums array
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        n = len(nums)
        result = [-1 for _ in range(len(nums))]
        stack = []
        
        for i in range(2*n):
            if len(stack) != 0 and stack[-1][0] < nums[i % n]:
                while len(stack) != 0 and stack[-1][0] < nums[i % n]:
                    num, index = stack.pop()
                    result[index] = nums[i % n]
            if i < n:
                stack.append((nums[i], i))
                
        
        return result