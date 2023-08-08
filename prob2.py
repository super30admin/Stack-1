# Time Complexity : O(n)
# Space Complexity :O(n)
# Passed on Leetcode: yes

class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        n = len(nums)
        result = [-1] * n  # Initialize the result list with -1
        stack = []  # Use a stack to keep track of indices
        
        for i in range(2 * n - 1):
            while stack and nums[i % n] > nums[stack[-1]]:
                prev_idx = stack.pop()
                result[prev_idx] = nums[i % n]
            stack.append(i % n)

        return result
