class Solution:
    # Time Complexity: O(n)
    # Space Complexity: O(n)
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        stack = []
        n = len(nums)
        result = len(nums) * [-1]
        for i in range(2 * n):
            while stack and nums[i % n] > nums[stack[-1]]:
                k = stack.pop()
                result[k] = nums[i % n]
                if stack and i % n == stack[-1]:
                    break
            stack.append(i % n)
        return result
