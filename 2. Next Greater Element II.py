class Solution:
    # Time Complexity - O(n)
    # Space Complexity - O(n) for the stack
    def nextGreaterElements(self, nums):
        if nums is None or len(nums) == 0: return []
        stack = []
        output = [-1 for i in range(len(nums))]
        n = len(nums)

        for i in range(2 * n):
            while len(stack) > 0 and nums[i % n] > nums[stack[-1]]:
                pos = stack.pop()
                output[pos] = nums[i % n]

            if i < n:
                stack.append(i)

        return output