# https://www.youtube.com/watch?v=fLwX7yBd1-I
# Monotonic decreasing stack type.
# Time : O(3n)
# Space : O(n)
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        n = len(nums)
        result = [-1]* n # Declaring the result array with all -1
        stack = [] # We'll be storing indices into the stack
        for i in range(2*n):
            while stack and nums[i%n]>nums[stack[-1]]: # As we'll be going through the array twice, we are doing i%n. While the curr element is greater than stack[-1], pop the index of that element from the stack
                popped_idx = stack.pop()
                result[popped_idx] = nums[i%n]
            if i<n : # If we are doing second pass, we dont have to put it into stack again.
                stack.append(i)
        return result