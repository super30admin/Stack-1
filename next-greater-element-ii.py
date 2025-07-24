# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        n = len(nums)
        result = [-1] * n
        stack = []
        
        # Handle circular array by traversing twice
        for i in range(2 * n):
            # Get the actual index in the original array
            actual_index = i % n
            
            # While stack is not empty and current element is greater than stack top
            while stack and nums[actual_index] > nums[stack[-1]]:
                # Update result for the element at stack top
                result[stack.pop()] = nums[actual_index]
            
            # Only push to stack during the first traversal
            if i < n:
                stack.append(actual_index)
        
        return result
        