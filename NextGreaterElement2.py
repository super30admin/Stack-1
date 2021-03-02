# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using Stack for this approach. Initialize a res array of length nums with -1
# Iterate over the nums array twice
# Index will be the index mod length of nums array
# Until stack is not empty and top of stack is less than current element we will pop the stack
# Then current element  will be stored in index of res that is popped from stack
# For each element, append the index to stack until i is less than length of nums, we dont need to append in second traversal
# Return res


class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        if not nums:
            return None
        res = [-1] * len(nums)
        stack = []
        for i in range(len(nums) * 2):
            i = i % len(nums)
            while stack and nums[stack[-1]] < nums[i]:
                index = stack.pop()
                res[index] = nums[i]
            if i < len(nums):
                stack.append(i)
        return res