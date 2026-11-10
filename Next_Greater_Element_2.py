# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using Stack for this approach. Initialize a result array of length nums with -1
# Iterate over the nums array twice since we need circular greater element
# Index will be the index % length of nums array
# Until stack is not empty and top of stack is less than current element we will pop the stack
# Then current element will be stored in index of result that is popped from stack
# For each element, append the index to stack until i is less than length of nums, we dont need to append in second traversal
# Return res

class Solution:
    def nextGreaterElements(self, nums: list[int]) -> list[int]:
        stack = []
        n = len(nums)
        result = [-1] * n
        for i in range(2*n):
            i = i % n
            while stack and nums[i] > nums[stack[-1]]:
                popped = stack.pop()
                result[popped] = nums[i]
            if i < n:
                stack.append(i)
        return result