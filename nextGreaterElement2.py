class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        # T: O(n), S: O(n)
        n = len(nums)
        res = [-1] * n
        stack = []  # Monotonic decreasing stack (stores indices)

        for i in range(2 * n):  # Iterate twice to simulate circular behavior
            while stack and nums[stack[-1]] < nums[i % n]:
                res[stack.pop()] = nums[i % n]
            if i < n:
                stack.append(i)

        return res
