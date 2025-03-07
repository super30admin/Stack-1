# Monotonic Stack
# TC : O(N)
# SC = O(N)
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        if len(nums) == 0:
            return []

        n = len(nums)
        result = [-1] * n
        stack = [] # montonic stack
        for i in range(2*n):
            while stack and nums[i%n] > nums[stack[-1]]:
                index = stack.pop()
                result[index] =  nums[i%n]
            if i < n:
                stack.append(i)
        return result









