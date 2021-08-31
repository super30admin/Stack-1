class Solution:
    def nextGreaterElements(self, nums) :
        n = len(nums)
        result = [-1 for i in range(n)]
        stack = []

        for i in range(2 * n):
            while stack and nums[i % n] > nums[stack[-1]]:
                index = stack.pop()
                result[index] = nums[i % n]
            if i < n:
                stack.append(i)
        return result
