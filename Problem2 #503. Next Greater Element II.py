# Time Complexity: O(N)
# Space COmplexity: O(1)

# Monotonic Increasing Stack

class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        # base
        if nums is None:
            return None

        # logic
        monotonic_stack = []
        result = []

        for i in range(2 * len(nums)):
            while monotonic_stack and nums[i % len(nums)] > nums[monotonic_stack.peek()]:
                idx = monotonic_stack.pop()
                result[idx] = nums[i % len(nums)]

            if i < len(nums):
                monotonic_stack.push(i)

        return result
