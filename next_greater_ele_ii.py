class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        stack = []
        n = len(nums)
        result = [-1] * n

        for i in range(2 * n - 1, -1, -1):
            while stack and nums[i % n] >= nums[stack[-1]]:
                stack.pop()
            if i < n and stack:
                result[i] = nums[stack[-1]]
            stack.append(i % n)
        return result


# time complexity is O(n)
# space complexity is O(n)
